package org.study.service.impl;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.study.dao.ResourceDAO;
import org.study.service.ResourceService;

@Service("resourceService")
public class ResourceServiceImpl implements ResourceService {

	@Resource(name="resourceDAO") private ResourceDAO resourceDAO;
	
	@Override
	public List<org.study.model.Resource> getResourceByUserid(Integer userid) {
		return  resourceDAO.getResourceByUserid(userid);
	}

	/**
	 * 提取Resource中url
	 */
	@Override
	public Set<String> getUrlsByUserid(Integer userid) {
		Set<org.study.model.Resource> resources = new HashSet<org.study.model.Resource>(getResourceByUserid(userid));
		Set<String> sets = new HashSet<String>();
		for(org.study.model.Resource r : resources) {
			sets.add(r.getUrl());
		}
		return sets;
	}

	/* (non-Javadoc)
	 * @see org.study.service.ResourceService#getAllResources()
	 * 查询所有的资源
	 */
	@Override
	public List<org.study.model.Resource> getAllResources() {
		return resourceDAO.getAll();
	}

}
