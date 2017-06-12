package org.study.dao.impl;

import java.util.List;

import org.springframework.stereotype.Repository;
import org.study.dao.UserDAO;
import org.study.model.User;


@Repository("uerDAO")
public class UserDAOImpl extends BaseDAOImpl<User> implements UserDAO<User> {

	@Override
	public User getUserByName(String loginname) {
		String hql = "from User u where u.loginName = ?";
		@SuppressWarnings("unchecked")
		List<User> users = (List<User>) this.getHibernateTemplate().find(hql, loginname);
		return null != users && users.size() > 0 ? users.get(0) : null;
	}

}
