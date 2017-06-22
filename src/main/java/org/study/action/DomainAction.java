package org.study.action;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.apache.shiro.SecurityUtils;
import org.apache.struts2.ServletActionContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.study.common.Contants;
import org.study.model.Resource;
import org.study.model.User;
import org.study.service.ResourceService;

import com.alibaba.fastjson.JSON;
import com.opensymphony.xwork2.ActionSupport;

public class DomainAction extends ActionSupport {

	/** */
	private static final long serialVersionUID = 1L;
	
	@Autowired ResourceService resourceService;

	/**
	 * 登录成功后跳转index页面
	 * @return
	 */
	public String domain() {
		
		return SUCCESS;
	}
	
	/**
	 * 初始化左侧的ztree树形数据结构
	 * @throws IOException 
	 */
	public void initZtree() throws IOException {
		User user = (User)SecurityUtils.getSubject().getSession().getAttribute(Contants.LOGIN_USER);
		List<Resource> resourceByUserid = resourceService.getResourceByUserid(user.getId());
		String json = JSON.toJSONString(resourceByUserid);
		HttpServletResponse response = ServletActionContext.getResponse();
		response.setContentType("text/json");
		response.setCharacterEncoding("UTF-8");
		PrintWriter writer = response.getWriter();
		writer.write(json);
		writer.flush();
		writer.close();
	}
	
}
