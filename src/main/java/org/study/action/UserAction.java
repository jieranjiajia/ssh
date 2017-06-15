package org.study.action;

import org.study.common.Contants;
import org.study.common.utils.StringUtils;
import org.study.exception.LoginException;
import org.study.model.User;

import com.opensymphony.xwork2.ActionSupport;

import javax.servlet.http.HttpSession;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.DisabledAccountException;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
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
		return SUCCESS;
	}

	/* 处理登录的操作 */
	public String dologin() {
		boolean isEmptyData = user == null || StringUtils.isBlank(user.getLoginName()) || StringUtils.isBlank(user.getPassword());
		if(isEmptyData) {
			addActionError("用户名或密码为空！");
			return LOGIN;
		}
		//第一步：检验验证码
		if(!checkCode()) {
			addActionError("验证码输入错误！");
			return LOGIN;
		} 
		
		//第二步：使用shiro进行登录验证操作
		try {
			UsernamePasswordToken token = new UsernamePasswordToken(user.getLoginName(), user.getPassword());
			token.setRememberMe(true);
			Subject subject = SecurityUtils.getSubject();
			subject.login(token);
		} catch (UnknownAccountException e) {
			//帐号不存在
			throw new LoginException("帐号不存在",e);
		} catch (DisabledAccountException e) {
			throw new LoginException("帐号未启用",e);
		} catch (IncorrectCredentialsException e) {
			throw new LoginException("用户名或密码错误",e);
		} catch (Throwable e) {
			throw new LoginException("系统未知错误",e);
		}
		return SUCCESS;
	}

	/**
	 * 验证输入的验证码，输入正确return true，错误return false
     */
	public boolean checkCode() {
		if(StringUtils.isNotBlank(checkCode)){
			HttpSession session = ServletActionContext.getRequest().getSession();
			String sessionCode = (String)session.getAttribute(Contants.CHECK_CODE);
			if(checkCode.equalsIgnoreCase(sessionCode)) {
				return true;
			}
		}
		return false;
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
