package org.study.service;

import java.util.List;
import java.util.Set;


public interface ResourceService {

	/** 
	 * 根据用户id查询所对应的资源信息
	 */
	List<org.study.model.Resource> getResourceByUserid(Integer userid); 
	
	Set<String> getUrlsByUserid(Integer userid);
	
	List<org.study.model.Resource> getAllResources();
	
}
