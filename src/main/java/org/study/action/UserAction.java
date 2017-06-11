package org.study.action;

import org.study.common.utils.StringUtils;
import org.study.model.User;

import com.opensymphony.xwork2.ActionSupport;
import org.apache.struts2.ServletActionContext;

/**
 * 用户action控制类
 * 控制用户的登录，修改密码，登出操作
 */
public class UserAction extends ActionSupport {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * 登录用户
     */
	private User user;
	/**
	 * 登录验证码
     */
	private String checkCode;

	/**
	 * 去往登陆操作
	 */
	public String toLogin() {
		return "login";
	}

	/* 处理登录的操作 */
	public String dologin() {
		//第一步：检验验证码
		HttpSession session = ServletActionContext.getRequest().getSession();
		
		//第二步：使用shiro进行登录验证操作

	}

	/**
	 *
     */
	public boolean checkCode() {
		if(StringUtils.isBlank(checkCode)) {
			return false;
		} else {
			
			
		}
	}

	//-----------getter setter methods------------

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public String getCheckCode() {
		return checkCode;
	}

	public void setCheckCode(String checkCode) {
		this.checkCode = checkCode;
	}
}
