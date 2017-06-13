package org.study.dao.impl;


import java.util.List;

import org.springframework.stereotype.Repository;
import org.study.dao.ResourceDAO;
import org.study.model.Resource;

@Repository("resourceDAO")
public class ResourceDAOImpl extends BaseDAOImpl<Resource> implements ResourceDAO {

	

	@Override
	public List<Resource> getResourceByUserid(Integer userid) {
		String hql = "select r from Resource r,RoleResource re,UserRole ur where r.id=re.resourceid and re.roleid = ur.roleid and ur.userid = ?";
		return getByProperty(hql,userid);
	}

}
