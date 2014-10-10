package com.open.wx.utils;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.URL;
import java.security.KeyManagementException;
import java.security.NoSuchAlgorithmException;
import java.security.NoSuchProviderException;
import java.util.Map;

import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSocketFactory;
import javax.net.ssl.TrustManager;

import org.apache.log4j.Logger;

import com.open.wx.bo.AccessToken;
import com.open.wx.bo.button.Menu;
import com.open.wx.cons.ConstStr;

/**
 * 公众平台通用接口工具类
 * 
 */
public class WechatUtil {
	/**
	 * 发起https请求并获取结果
	 * 
	 * 1）41~50行：解决https请求的问题，很多人问题就出在这里； 2）55~59行：兼容GET、POST两种方式；
	 * 3）61~67行：兼容有数据提交、无数据提交两种情况，也有相当一部分人不知道如何POST提交数据；
	 * 
	 * @param requestUrl
	 * @param requestMethod
	 * @param outputStr
	 * @return JSONObject(通过JSONObject.get(key)的方式获取json对象的属性值)
	 * @throws NoSuchAlgorithmException
	 * @throws NoSuchProviderException
	 * @throws KeyManagementException
	 * @throws IOException
	 */
	private  final static Logger log = Logger.getLogger(WechatUtil.class);
	
	public static String httpRequest(String requestUrl, String requestMethod,
			String outputStr) throws NoSuchAlgorithmException,
			NoSuchProviderException, KeyManagementException, IOException {
		// JSONObject jsonObj = null;
		StringBuffer buffer = new StringBuffer();
		// 创建SSLContext对象，并使用我们指定的信任管理器初始化
		TrustManager[] tm = { new WechatX509TrustManager() };
		SSLContext sslContext = SSLContext.getInstance("SSL", "SunJSSE");
		sslContext.init(null, tm, new java.security.SecureRandom());
		// 从上述SSLContext对象中得到SSLSocketFactory对象
		SSLSocketFactory sslSF = sslContext.getSocketFactory();

		URL url = new URL(requestUrl);
		HttpsURLConnection httpUrlConn = (HttpsURLConnection) url
				.openConnection();
		httpUrlConn.setSSLSocketFactory(sslSF);

		httpUrlConn.setDoOutput(true);
		httpUrlConn.setDoInput(true);
		httpUrlConn.setUseCaches(false);

		// 设置请求方式GET or POST
		httpUrlConn.setRequestMethod(requestMethod);

		if ("GET".equalsIgnoreCase(requestMethod)) {
			httpUrlConn.connect();
		}
		// 当有数据要提交时
		if (outputStr != null) {
			OutputStream outputStream = httpUrlConn.getOutputStream();
			// 注意编码格式，防止中文乱码
			outputStream.write(outputStr.getBytes("UTF-8"));
			outputStream.close();
		}

		// 将返回的输入流转换成字符串
		InputStream inputStream = httpUrlConn.getInputStream();
		InputStreamReader inputStreamReader = new InputStreamReader(
				inputStream, "UTF-8");
		BufferedReader bufferedReader = new BufferedReader(inputStreamReader);

		String str = null;
		while ((str = bufferedReader.readLine()) != null) {
			buffer.append(str);
		}
		bufferedReader.close();
		inputStreamReader.close();
		// 释放资源
		inputStream.close();
		inputStream = null;
		httpUrlConn.disconnect();

		return buffer.toString();
	}

	/**
	 * 获取access_token
	 * 
	 * @param appid
	 * @param appsecret
	 * @return
	 * @throws IOException
	 * @throws NoSuchProviderException
	 * @throws NoSuchAlgorithmException
	 * @throws KeyManagementException
	 */
	// http://blog.csdn.net/lyq8479/article/details/9841371
	@SuppressWarnings("rawtypes")
	public static AccessToken getAccessToken(String appid, String appsecret)
			throws KeyManagementException, NoSuchAlgorithmException,
			NoSuchProviderException, IOException {
		AccessToken accessToken = null;

		String requestUrl = ConstStr.ACCESS_TOKEN_URL
				.replace("APPID", appid).replace("APPSECRET", appsecret);

		String jsonReinfo = httpRequest(requestUrl, "GET", null);
		// System.out.println(jsonReinfo);
		// 如果请求成功
		if (jsonReinfo != null) {
			Map jsonMap = GsonUtil.json2Obj(jsonReinfo);
			accessToken = new AccessToken();
			accessToken.setAccess_token(jsonMap.get("access_token"));
			accessToken.setExpires_in(jsonMap.get("expires_in"));
		} else {
			// 请求失败
		}
		return accessToken;
	}

	/**
	 * 创建菜单
	 * 
	 * @param menu
	 * @param accessToken
	 * @return 返回0表示创建菜单创建成功
	 * @throws IOException
	 * @throws NoSuchProviderException
	 * @throws NoSuchAlgorithmException
	 * @throws KeyManagementException
	 */
	@SuppressWarnings("rawtypes")
	public static Object createMenu(Menu menu, String accessToken)
			throws KeyManagementException, NoSuchAlgorithmException,
			NoSuchProviderException, IOException {
		Object reCode = 0;
		Object reMsg;
		// 拼接创建菜单的url
		String url = ConstStr.MENU_CREATE_URL.replace("ACCESS_TOKEN",
				accessToken);

		String jsonMenu = GsonUtil.obj2Json(menu);

		String jsonReinfo = httpRequest(url, "POST", jsonMenu);

		if (jsonReinfo != null) {
			Map jsonMap = GsonUtil.json2Obj(jsonReinfo);
			reCode = jsonMap.get("errcode");
			reMsg = jsonMap.get("errmsg");
			if (!reCode.equals(0.0D)) {
				log.debug(reCode+":"+reMsg);
				return reCode;
			}
		}
		return reCode;
	}
}
