package org.study.dao;

import java.util.List;

import org.study.model.Resource;

public interface ResourceDAO extends BaseDAO<Resource> {

	List<Resource> getResourceByUserid(Integer userid);
	
}
