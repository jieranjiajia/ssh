package org.study.action;

import org.study.model.User;

import com.opensymphony.xwork2.ActionSupport;

/**
 * 用户action控制类
 * 控制用户的登录，修改密码，登出操作
 */
public class UserAction extends ActionSupport {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private User user;
	
	/**
	 * 去往登陆操作
	 */
	public String toLogin() {
		return "login";
	}

	
	
	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}
	
}
