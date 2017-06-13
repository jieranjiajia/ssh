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
	public Set<org.study.model.Resource> getResourceByUserid(Integer userid) {
		List<org.study.model.Resource> resources = resourceDAO.getResourceByUserid(userid);
		return new HashSet<org.study.model.Resource>(resources);
	}

	/**
	 * 提取Resource中url
	 */
	@Override
	public Set<String> getUrlsByUserid(Integer userid) {
		Set<org.study.model.Resource> resources = getResourceByUserid(userid);
		Set<String> sets = new HashSet<String>();
		for(org.study.model.Resource r : resources) {
			sets.add(r.getUrl());
		}
		return sets;
	}

}
