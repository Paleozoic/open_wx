package com.open.wx.utils;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;

import com.open.wx.cons.ConstStr;
/**
 * 验证签名工具类
 */
public class SignUtil {
	/**
	 * 验证签名
	 * 
	 * 参数			描述
	 *signature		微信加密签名，signature结合了开发者填写的StaticUtil.FinalString.TOKEN参数和请求中的timestamp参数、nonce参数。
	 *timestamp		时间戳
	 *  nonce		随机数
	 * echostr		随机字符串
	 * @param signature
	 * @param timestamp
	 * @param nonce
	 * @return
	 */
	public static boolean checkSignature(String signature,String timestamp,String nonce) throws NoSuchAlgorithmException{
		String[] arr = new String[]{ConstStr.TOKEN,timestamp,nonce};
		//将FinalString.TOKEN、timestamp、nonce按字典进行排序
		Arrays.sort(arr);
		StringBuilder content = new StringBuilder();
		for(int i=0;i<arr.length;i++){
			content.append(arr[i]);
		}
		
		// 将三个参数字符串拼接成一个字符串进行sha1加密
		MessageDigest md = MessageDigest.getInstance("SHA-1");

		byte[] digest = md.digest(content.toString().getBytes());
		String tmpStr = byteToStr(digest);
		
		content = null;
		// 将sha1加密后的字符串可与signature对比，标识该请求来源于微信  
		return tmpStr != null ? tmpStr.equals(signature.toUpperCase()) : false;
	}
	/**
	 * 将字节数组转换为十六进制字符串
	 * 
	 * @param bArr
	 * @return
	 */
	private static String byteToStr(byte[] bArr) {
		// TODO Auto-generated method stub
		String strDigest="";
		for(int i=0;i<bArr.length;i++){
			strDigest += byteToHexStr(bArr[i]);
		}
		return strDigest;
	}
	/**
	 * 将字节转换为十六进制字符串
	 * 
	 * @param b
	 * @return
	 */
	private static String byteToHexStr(byte b) {
		// TODO Auto-generated method stub
		char[] Digit =  { '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F' };
		char[] tmp = new char[2];
		tmp[0] = Digit[(b >>> 4)&0X0F];
		tmp[1] = Digit[b & 0X0F];
		
		String str  = new String(tmp);
		return str;
	}
}
