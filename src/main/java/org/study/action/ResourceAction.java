package org.study.action;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.study.common.BaseAction;
import org.study.model.Resource;
import org.study.service.ResourceService;

import com.alibaba.fastjson.JSON;

public class ResourceAction extends BaseAction {

	
	/** */
	private static final long serialVersionUID = 1L;
	
	
	@Autowired ResourceService resourceService;
	
	private List<Resource> allResources;

	/** 去往资源管理的界面 */
	public String manager() {
		return SUCCESS;
	}
	
	/**
	 * ajax请求资源数据
	 */
	public void getResourceData() {
		allResources = resourceService.getAllResources();
		String jsonStr = JSON.toJSONString(allResources);
		super.writeMessageToJsp(jsonStr);
	}
	
	public List<Resource> getAllResources() {
		return allResources;
	}

	public void setAllResources(List<Resource> allResources) {
		this.allResources = allResources;
	}
	
}
