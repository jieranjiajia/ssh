package org.study.action;

import com.opensymphony.xwork2.ActionSupport;

public class DomainAction extends ActionSupport {

	/** */
	private static final long serialVersionUID = 1L;

	/**
	 * 登录成功后跳转index页面
	 * @return
	 */
	public String domain() {
		
		return SUCCESS;
	}
	
}
