package org.study.action;

import javax.servlet.http.HttpServletResponse;
import org.study.common.BaseAction;
import org.study.common.CheckCode;
import org.study.common.Contants;

/**
 * 获取验证码的action
 * @author Administrator
 *
 */
public class CheckCodeAction extends BaseAction {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public void getCheckCode() throws Exception {
		HttpServletResponse response = getResponse();
		// 取得验证码
		String code = CheckCode.generateCode();
		//写出验证码
		CheckCode.genarateCode(response, code);
		//如果有缓存，可以将这个数据放入cookie中
		super.setAttributeInSession(Contants.CHECK_CODE, code);
	}

}
