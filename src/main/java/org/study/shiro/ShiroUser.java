package org.study.shiro;

import java.io.Serializable;
import java.util.Set;

import org.study.model.User;

public class ShiroUser implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	/** 主键 */
	private Integer id;
	/** 登录名 */
	private String loginname;
	/** URL集合 */
	private Set<String> urlSet;
	/** 角色 */
	private Set<String> roles;
	
	/** 通过查询出的user构造一个shiroUser */
	public ShiroUser(User user) {
		this.id = user.getId();
		this.loginname = user.getLoginName();
		this.roles = user.getRolesString();
	}
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getLoginname() {
		return loginname;
	}
	public void setLoginname(String loginname) {
		this.loginname = loginname;
	}
	public Set<String> getUrlSet() {
		return urlSet;
	}
	public void setUrlSet(Set<String> urlSet) {
		this.urlSet = urlSet;
	}
	public Set<String> getRoles() {
		return roles;
	}
	public void setRoles(Set<String> roles) {
		this.roles = roles;
	}
	
	
	/**
	 * 本函数输出将作为默认的<shiro:principal/>输出.
	 */
	@Override
	public String toString() {
		return getLoginname();
	}
	

	
	
}
