package com.open.wx.services;

import java.io.UnsupportedEncodingException;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;

import com.open.wx.bo.AccessToken;
import com.open.wx.bo.button.Button;
import com.open.wx.bo.button.CommonButton;
import com.open.wx.bo.button.ComplexButton;
import com.open.wx.bo.button.Menu;
import com.open.wx.cons.ConstStr;
import com.open.wx.cons.MenuStr;
import com.open.wx.utils.WechatUtil;

/**
 * 菜单管理类
 * 
 */
@Service("wx.services.MenuMgrService")
public class MenuMgrService implements IMenuMgrService {
	
	private  final static Logger log = Logger.getLogger(MenuMgrService.class);
	
	@Override
	public void create() {
		// 调用接口获取access_token
		AccessToken at;
		try {
			at = WechatUtil.getAccessToken(ConstStr.AppId,
					ConstStr.AppSecret);
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
		if (at != null) {
			// 调用接口创建菜单
			Object result =null;
			try {
				result = WechatUtil.createMenu(getMenu(),
						at.getAccess_token());
			} catch (Exception e) {
				throw new RuntimeException(e);
			}
			// 判断菜单创建结果
			if (result.equals(0.0D)){
				log.debug("菜单创建成功！");
			}else{
				 log.debug("菜单创建失败，错误码：" + result);
			}
		}
	}
	
	/**
	 * 组装菜单数据
	 * @return
	 * @throws UnsupportedEncodingException
	 */
	private Menu getMenu() throws UnsupportedEncodingException {
		
		CommonButton btn11 = new CommonButton();
		btn11.setKeyButton(MenuStr.keyBtn11[0],MenuStr.keyBtn11[1]);
		CommonButton btn12 = new CommonButton();
		btn12.setKeyButton(MenuStr.keyBtn12[0],MenuStr.keyBtn12[1]);
		CommonButton btn13 = new CommonButton();
		btn13.setViewButton(MenuStr.viewBtn13[0],MenuStr.viewBtn13[1]);
		CommonButton btn14 = new CommonButton();
		btn14.setKeyButton(MenuStr.keyBtn14[0],MenuStr.keyBtn14[1]);
		
		
		CommonButton btn21 = new CommonButton();
		btn21.setKeyButton(MenuStr.keyBtn21[0],MenuStr.keyBtn21[1]);
		CommonButton btn22 = new CommonButton();
		btn22.setKeyButton(MenuStr.keyBtn22[0],MenuStr.keyBtn22[1]);
		CommonButton btn23 = new CommonButton();
		btn23.setViewButton(MenuStr.viewBtn23[0],MenuStr.viewBtn23[1]);
		CommonButton btn24 = new CommonButton();
		btn24.setKeyButton(MenuStr.keyBtn24[0],MenuStr.keyBtn24[1]);
		
		
		CommonButton btn31 = new CommonButton();
		btn31.setKeyButton(MenuStr.keyBtn31[0],MenuStr.keyBtn31[1]);
		
		
		ComplexButton mainBtn1 = new ComplexButton();
		mainBtn1.setName(MenuStr.mainBtn[0]);
		mainBtn1.setSub_button(new CommonButton[] { btn11, btn12, btn13, btn14 });
		ComplexButton mainBtn2 = new ComplexButton();
		mainBtn2.setName(MenuStr.mainBtn[1]);
		mainBtn2.setSub_button(new CommonButton[] { btn21, btn22, btn23, btn24 });
		ComplexButton mainBtn3 = new ComplexButton();
		mainBtn3.setName(MenuStr.mainBtn[2]);
		mainBtn3.setSub_button(new CommonButton[] { btn31 });
		
		Menu menu = new Menu();
		menu.setButton(new Button[] { mainBtn1, mainBtn2, mainBtn3 });
		return menu;
	}
	

}
