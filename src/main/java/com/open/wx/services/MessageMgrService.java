package com.open.wx.services;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Service;

import com.open.wx.bo.message.response.Article;
import com.open.wx.bo.message.response.NewsMessage;
import com.open.wx.cons.ConstStr;
import com.open.wx.utils.MsgUtil;

/**
 * 创建消息的服务类
 * 
 */
@Service("wx.services.MessageMgrService")
public class MessageMgrService implements IMessageMgrService {
	/**
	 * 创建多条图文的消息
	 */

	@Override
	public String createBindCreditsNewsMessage(String fromUserName,
			String toUserName) {
		String respMessage=null;
		NewsMessage newsMessage = new NewsMessage();  
	    newsMessage.setToUserName(fromUserName);  
	    newsMessage.setFromUserName(toUserName);  
	    newsMessage.setCreateTime(new Date().getTime());  
	    newsMessage.setMsgType(ConstStr.RESP_MESSAGE_TYPE_NEWS);  
	    newsMessage.setFuncFlag(0);  

	    List<Article> articleList = new ArrayList<Article>();  
		Article article = new Article();  
	    article.setTitle("标题");  
	    article.setDescription("描述");  
	    article.setPicUrl("http://img5.imgtn.bdimg.com/it/u=471290409,3022938062&fm=21&gp=0.jpg");  
	    article.setUrl("http:/www.baidu.com");
	    
	    articleList.add(article);
	    // 设置图文消息个数
	    newsMessage.setArticleCount(articleList.size());  
	    // 设置图文消息包含的图文集合  
	    newsMessage.setArticles(articleList);  
	    // 将图文消息对象转换成xml字符串  
	    respMessage = MsgUtil.newsMessageToXml(newsMessage); 
		return respMessage;
	}

	@Override
	public String createCreditsQueryNewsMessage(String fromUserName,
			String toUserName) {
		String respMessage=null;
		
		// 创建图文消息  
        NewsMessage newsMessage = new NewsMessage();  
        newsMessage.setToUserName(fromUserName);  
        newsMessage.setFromUserName(toUserName);  
        newsMessage.setCreateTime(new Date().getTime());  
        newsMessage.setMsgType(ConstStr.RESP_MESSAGE_TYPE_NEWS);  
        newsMessage.setFuncFlag(0);  

        List<Article> articleList = new ArrayList<Article>();  
		Article article = new Article();  
	    article.setTitle("标题");  
	    article.setDescription("描述");  
	    article.setPicUrl("http://img5.imgtn.bdimg.com/it/u=471290409,3022938062&fm=21&gp=0.jpg");  
	    article.setUrl("http:/www.baidu.com");
	     
        articleList.add(article);
        // 设置图文消息个数  
        newsMessage.setArticleCount(articleList.size());  
        // 设置图文消息包含的图文集合  
        newsMessage.setArticles(articleList);  
        // 将图文消息对象转换成xml字符串  
        respMessage = MsgUtil.newsMessageToXml(newsMessage); 
		return respMessage;
	}

	@Override
	public String createCreditsExchangeNewsMessage(String fromUserName,
			String toUserName) {
		String respMessage = null;
		NewsMessage newsMessage = new NewsMessage();
		newsMessage.setToUserName(fromUserName);
		newsMessage.setFromUserName(toUserName);
		newsMessage.setCreateTime(new Date().getTime());
		newsMessage.setMsgType(ConstStr.RESP_MESSAGE_TYPE_NEWS);
		newsMessage.setFuncFlag(0);
	
		List<Article> articleList = new ArrayList<Article>();
		Article article = new Article();  
	    article.setTitle("标题");  
	    article.setDescription("描述");  
	    article.setPicUrl("http://img5.imgtn.bdimg.com/it/u=471290409,3022938062&fm=21&gp=0.jpg");  
	    article.setUrl("http:/www.baidu.com");
		articleList.add(article);
		
		newsMessage.setArticleCount(articleList.size());
		newsMessage.setArticles(articleList);
		respMessage = MsgUtil.newsMessageToXml(newsMessage);

		return respMessage;
	}


	@Override
	public String createAboutUsNewsMessage(String fromUserName,
			String toUserName) {
		String respMessage = null;
		NewsMessage newsMessage = new NewsMessage();
		newsMessage.setToUserName(fromUserName);
		newsMessage.setFromUserName(toUserName);
		newsMessage.setCreateTime(new Date().getTime());
		newsMessage.setMsgType(ConstStr.RESP_MESSAGE_TYPE_NEWS);
		newsMessage.setFuncFlag(0);

		List<Article> articleList = new ArrayList<Article>();
		Article article = new Article();
	    article.setTitle("标题");  
	    article.setDescription("描述");  
	    article.setPicUrl("http://img5.imgtn.bdimg.com/it/u=471290409,3022938062&fm=21&gp=0.jpg");  
	    article.setUrl("http:/www.baidu.com");
		articleList.add(article);
		// 设置图文消息个数
		newsMessage.setArticleCount(articleList.size());
		// 设置图文消息包含的图文集合
		newsMessage.setArticles(articleList);
		// 将图文消息对象转换成xml字符串
		respMessage = MsgUtil.newsMessageToXml(newsMessage);

		return respMessage;
	}


	@Override
	public String createBusinessNewsMessage(String fromUserName,
			String toUserName) {
		String respMessage = null;
		NewsMessage newsMessage = new NewsMessage();
		newsMessage.setToUserName(fromUserName);
		newsMessage.setFromUserName(toUserName);
		newsMessage.setCreateTime(new Date().getTime());
		newsMessage.setMsgType(ConstStr.RESP_MESSAGE_TYPE_NEWS);
		newsMessage.setFuncFlag(0);

		List<Article> articleList = new ArrayList<Article>();

		Article article1 = new Article();
	    article1.setTitle("标题");  
	    article1.setDescription("描述");  
	    article1.setPicUrl("http://img5.imgtn.bdimg.com/it/u=471290409,3022938062&fm=21&gp=0.jpg");  
	    article1.setUrl("http:/www.baidu.com");
		

		Article article2 = new Article();
	    article2.setTitle("标题");  
	    article2.setDescription("描述");  
	    article2.setPicUrl("http://img5.imgtn.bdimg.com/it/u=471290409,3022938062&fm=21&gp=0.jpg");  
	    article2.setUrl("http:/www.baidu.com");

		Article article3 = new Article();
	    article3.setTitle("标题");  
	    article3.setDescription("描述");  
	    article3.setPicUrl("http://img5.imgtn.bdimg.com/it/u=471290409,3022938062&fm=21&gp=0.jpg");  
	    article3.setUrl("http:/www.baidu.com");

		Article article4 = new Article();
	    article4.setTitle("标题");  
	    article4.setDescription("描述");  
	    article4.setPicUrl("http://img5.imgtn.bdimg.com/it/u=471290409,3022938062&fm=21&gp=0.jpg");  
	    article4.setUrl("http:/www.baidu.com");

		Article article5 = new Article();
	    article5.setTitle("标题");  
	    article5.setDescription("描述");  
	    article5.setPicUrl("http://img5.imgtn.bdimg.com/it/u=471290409,3022938062&fm=21&gp=0.jpg");  
	    article5.setUrl("http:/www.baidu.com");

		articleList.add(article1);
		articleList.add(article2);
		articleList.add(article3);
		articleList.add(article4);
		articleList.add(article5);
		newsMessage.setArticleCount(articleList.size());
		newsMessage.setArticles(articleList);
		respMessage = MsgUtil.newsMessageToXml(newsMessage);

		return respMessage;
	}


	@Override
	public String createNetWorkNewsMessage(String fromUserName,
			String toUserName) {
		String respMessage = null;
		NewsMessage newsMessage = new NewsMessage();
		newsMessage.setToUserName(fromUserName);
		newsMessage.setFromUserName(toUserName);
		newsMessage.setCreateTime(new Date().getTime());
		newsMessage.setMsgType(ConstStr.RESP_MESSAGE_TYPE_NEWS);
		newsMessage.setFuncFlag(0);

		List<Article> articleList = new ArrayList<Article>();
		Article article = new Article();
	    article.setTitle("标题");  
	    article.setDescription("描述");  
	    article.setPicUrl("http://img5.imgtn.bdimg.com/it/u=471290409,3022938062&fm=21&gp=0.jpg");  
	    article.setUrl("http:/www.baidu.com");
		articleList.add(article);
		// 设置图文消息个数
		newsMessage.setArticleCount(articleList.size());
		// 设置图文消息包含的图文集合
		newsMessage.setArticles(articleList);
		// 将图文消息对象转换成xml字符串
		respMessage = MsgUtil.newsMessageToXml(newsMessage);

		return respMessage;
	}


	@Override
	public String createFinancialProductsNewsMessage(String fromUserName,
			String toUserName) {
		String respMessage = null;
		NewsMessage newsMessage = new NewsMessage();
		newsMessage.setToUserName(fromUserName);
		newsMessage.setFromUserName(toUserName);
		newsMessage.setCreateTime(new Date().getTime());
		newsMessage.setMsgType(ConstStr.RESP_MESSAGE_TYPE_NEWS);
		newsMessage.setFuncFlag(0);

		List<Article> articleList = new ArrayList<Article>();
		Article article = new Article();
	    article.setTitle("标题");  
	    article.setDescription("描述");  
	    article.setPicUrl("http://img5.imgtn.bdimg.com/it/u=471290409,3022938062&fm=21&gp=0.jpg");  
	    article.setUrl("http:/www.baidu.com");
		articleList.add(article);
		// 设置图文消息个数
		newsMessage.setArticleCount(articleList.size());
		// 设置图文消息包含的图文集合
		newsMessage.setArticles(articleList);
		// 将图文消息对象转换成xml字符串
		respMessage = MsgUtil.newsMessageToXml(newsMessage);

		return respMessage;
	}



	@Override
	public String createActivityNewsMessage(String fromUserName,
			String toUserName) {
		String respMessage = null;
		NewsMessage newsMessage = new NewsMessage();
		newsMessage.setToUserName(fromUserName);
		newsMessage.setFromUserName(toUserName);
		newsMessage.setCreateTime(new Date().getTime());
		newsMessage.setMsgType(ConstStr.RESP_MESSAGE_TYPE_NEWS);
		newsMessage.setFuncFlag(0);

		List<Article> articleList = new ArrayList<Article>();
		Article article = new Article();
	    article.setTitle("标题");  
	    article.setDescription("描述");  
	    article.setPicUrl("http://img5.imgtn.bdimg.com/it/u=471290409,3022938062&fm=21&gp=0.jpg");  
	    article.setUrl("http:/www.baidu.com");
		articleList.add(article);
		// 设置图文消息个数
		newsMessage.setArticleCount(articleList.size());
		// 设置图文消息包含的图文集合
		newsMessage.setArticles(articleList);
		// 将图文消息对象转换成xml字符串
		respMessage = MsgUtil.newsMessageToXml(newsMessage);

		return respMessage;
	}
}
