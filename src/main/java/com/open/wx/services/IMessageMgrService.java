package com.open.wx.services;

public interface IMessageMgrService {
	public String createBindCreditsNewsMessage(String fromUserName,String toUserName);
	public String createCreditsQueryNewsMessage(String fromUserName,String toUserName);
	public String createCreditsExchangeNewsMessage(String fromUserName,String toUserName);
	public String createAboutUsNewsMessage(String fromUserName,String toUserName);
	public String createBusinessNewsMessage(String fromUserName,String toUserName);
	public String createNetWorkNewsMessage(String fromUserName,String toUserName);
	public String createFinancialProductsNewsMessage(String fromUserName,String toUserName);
	public String createActivityNewsMessage(String fromUserName,String toUserName);

}
