package org.study.action;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;
import org.study.common.CheckCode;
import org.study.common.Contants;

import com.opensymphony.xwork2.ActionSupport;

/**
 * 获取验证码的action
 * @author Administrator
 *
 */
public class CheckCodeAction extends ActionSupport {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	public String execute() throws Exception {
		
		HttpSession session = ServletActionContext.getRequest().getSession();
		HttpServletResponse response = ServletActionContext.getResponse();
		// 取得验证码
		String code = CheckCode.generateCode();
		//写出验证码
		CheckCode.genarateCode(response, code);
		//如果有缓存，可以将这个数据放入cookie中
		session.setAttribute(Contants.CHECK_CODE, code);
		return null;
	}

}
