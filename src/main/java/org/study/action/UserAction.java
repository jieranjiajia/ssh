package org.study.action;

import org.study.common.Contants;
import org.study.common.utils.StringUtils;
import org.study.model.User;

import com.opensymphony.xwork2.ActionSupport;

import java.util.Objects;

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
		//第一步：检验验证码
		if(checkCode()) {
			addActionError("验证码输入错误！");
			return LOGIN;
		} 
		
		//第二步：使用shiro进行登录验证操作
		try {
			UsernamePasswordToken token = new UsernamePasswordToken(user.getLoginName(), user.getPassword());
			Subject subject = SecurityUtils.getSubject();
			subject.login(token);
			token.setRememberMe(true);
		} catch (UnknownAccountException e) {
			//帐号不存在
			addActionError("帐号不存在");
			return LOGIN;
		} catch (DisabledAccountException e) {
			addActionError("帐号为启用");
			return LOGIN;
		} catch (IncorrectCredentialsException e) {
			addActionError("用户名或密码错误");
			return LOGIN;
		} catch (Throwable e) {
			addActionError("系统未知错误");
			return LOGIN;
		}
		
		return SUCCESS;
	}

	/**
	 * 验证输入的验证码
     */
	public boolean checkCode() {
		if(StringUtils.isNotBlank(checkCode)){
			HttpSession session = ServletActionContext.getRequest().getSession();
			String sessionCode = (String)session.getAttribute(Contants.CHECK_CODE);
			if(Objects.equals(checkCode, sessionCode)){
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
