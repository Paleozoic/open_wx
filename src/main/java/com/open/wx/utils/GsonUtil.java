package com.open.wx.utils;

import java.util.List;
import java.util.Map;

import org.springframework.util.StringUtils;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

/**
 * 为google gson api 设置的辅助工具类
 * 
 */
public class GsonUtil {
	
	private final static Gson GSON_BUILD = new Gson();
	
	/**
	 * 转换对象为json数据
	 * @param obj
	 * @return
	 */
	public static String  obj2Json(Object obj){
		return GSON_BUILD.toJson(obj)	;
	}
	
	/**
	 * 转换json数据为对象
	 * @param json
	 * @param classOfT
	 * @return
	 */
	public static <T>  T  json2Obj(String json,Class<T> classOfT){
		return GSON_BUILD.fromJson(json, classOfT);
	}
	
	/**
	 * 转换json数据为对象列表
	 * @param json
	 * @param classOfT
	 * @return
	 */
	public static <T>  List<T>  json2List(String json,Class<T> classOfT){
		return GSON_BUILD.fromJson(json, new TypeToken<List<T>>(){}.getType());
	}
	
	
	/**
	 * 转换json数据为对象
	 * @param json
	 * @param classOfT
	 * @return
	 */
	@SuppressWarnings("rawtypes")
	public static Map  json2Obj(String json){
		if(!StringUtils.isEmpty(json)){
			return json2Obj(json, Map.class);
		}else{
			return null;
		}
	}
	
	/**
	 * 转换json数据为对象列表
	 * @param json
	 * @param classOfT
	 * @return
	 */
	@SuppressWarnings("rawtypes")
	public static  List<Map>  json2List(String json){
		if(!StringUtils.isEmpty(json)){
		return json2List(json, Map.class);
	}else{
		return null;
	}
	}
	
}