package com.open.wx.bo;

public class AccessToken {
	// 获取到的凭证，和token不同，token是自定义的，而access_token是微信认证后返回的一个字符串
	private String access_token;
	// 凭证的有效期
	private Object expires_in;
	
	public String getAccess_token() {
		return access_token;
	}
	public void setAccess_token(Object object) {
		this.access_token = (String) object;
	}
	public Object getExpires_in() {
		return expires_in;
	}
	public void setExpires_in(Object object) {
		this.expires_in = object;
	}	
}
