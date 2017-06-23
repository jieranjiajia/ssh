package org.study.common;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.io.IOUtils;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.session.Session;
import org.apache.struts2.ServletActionContext;
import org.study.shiro.ShiroUser;

import com.opensymphony.xwork2.ActionSupport;

public class BaseAction extends ActionSupport {

	/** */
	private static final long serialVersionUID = 1L;

	/** 获取一个request*/
	public HttpServletRequest getResquest() {
		return ServletActionContext.getRequest();
	}
	
	/** 获取一个response */
	public HttpServletResponse getResponse() {
		return ServletActionContext.getResponse();
	}
	
	/** 获取一个HttpSession */
	public HttpSession getSession() {
		return getResquest().getSession();
	}
	
	/** 获取当前登录的用户 */
	public ShiroUser getLoginUser() {
		Session session = SecurityUtils.getSubject().getSession(false);
		return (ShiroUser) session.getAttribute(Contants.LOGIN_USER);
	}
	
	/** 往session中添加一个键值对 */
	public void setAttributeInSession(String key,Object value) {
		this.getSession().setAttribute(key, value);
	}
	
	/** 将一个数据以流的形式写到jsp页面 */
	public void writeMessageToJsp(String message) {
		HttpServletResponse response = this.getResponse();
		response.setContentType("text/json");
		response.setCharacterEncoding("UTF-8");
		PrintWriter writer = null;
		try {
			writer = response.getWriter();
			writer.write(message);
			writer.flush();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			IOUtils.closeQuietly(writer);
		}
	}
	
	/** 写出一个ajax的信息 */
	public void writeAjaxMessage(AjaxParam ap) {
		this.writeMessageToJsp(ap.toString());
	}
	
}
