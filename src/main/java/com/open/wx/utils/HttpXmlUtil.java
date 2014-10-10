package com.open.wx.utils;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletResponse;

/**
 * http 的json 的数据工具类
 * 
 */
public class HttpXmlUtil {
	/**
	 * 输出字符串形式的 XML 数据
	 * @param response
	 * @param xml
	 * @param xmlOutType
	 * @param encoding
	 */
	public static void writeOutStr(HttpServletResponse response, String  xml,boolean xmlOutType,String encoding) {
		writeOutStr(response,xml,xmlOutType,null,encoding);
	}
	
	public static void writeOutStr(HttpServletResponse response, String  xml,boolean xmlOutType,Integer resStatus,String encoding) {
		if(resStatus!=null){response.setStatus(resStatus);}
		if (xmlOutType) {
			response.setContentType("application/xml;charset="+encoding);
		} else {
			response.setContentType("text/html;charset="+encoding);
		}
		PrintWriter out = null;
		try {
			int length = xml.getBytes(encoding).length;
			response.setContentLength(length);
			out = response.getWriter();
			out.print(xml);
			out.close();
		} catch (Exception e) {
			//抛出异常
		} finally {
			if (out != null) {
				out.close();
			}
		}
	}
	
}