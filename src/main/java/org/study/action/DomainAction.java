package org.study.action;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.study.common.BaseAction;
import org.study.model.Resource;
import org.study.service.ResourceService;
import org.study.shiro.ShiroUser;

import com.alibaba.fastjson.JSON;

public class DomainAction extends BaseAction {

	/** */
	private static final long serialVersionUID = 1L;
	
	@Autowired ResourceService resourceService;

	
	public String domain() {
		return SUCCESS;
	}
	
	/**
	 * 初始化左侧的ztree树形数据结构
	 * @throws IOException 
	 */
	public void initZtree() {
		ShiroUser user = super.getLoginUser();
		List<Resource> resourceByUserid = resourceService.getResourceByUserid(user.getId());
		String json = JSON.toJSONString(resourceByUserid);
		super.writeMessageToJsp(json);
	}
	
}
