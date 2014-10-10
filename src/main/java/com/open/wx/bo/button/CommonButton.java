package com.open.wx.bo.button;
/**
 * 普通按钮
 * 定义：没有子菜单的菜单项，有可能是二级菜单项，也有可能是不含二级菜单的一级菜单。
 * 这类子菜单项一定会包含二个属性：type、name。KeyButton还有一个属性Key，而ViewButton还有一个属性url。
 */
public class CommonButton extends Button{
	private String type,key,url;

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getKey() {
		return key;
	}

	public void setKey(String key) {
		this.key = key;
	}	
	
	public void setKeyButton(String name,String key){
		this.setName(name);
		this.setType("click");
		this.setKey(key);
	}
	
	public void setViewButton(String name,String url){
		this.setName(name);
		this.setType("view");
		this.setUrl(url);
	}
}
