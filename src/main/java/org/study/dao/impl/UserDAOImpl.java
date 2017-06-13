package org.study.dao.impl;

import java.util.List;

import org.springframework.stereotype.Repository;
import org.study.dao.UserDAO;
import org.study.model.User;


@Repository("userDAO")
public class UserDAOImpl extends BaseDAOImpl<User> implements UserDAO {

	@Override
	public User getUserByName(String loginname) {
		String hql = "from User u where u.loginName = ?";
		List<User> users = (List<User>) getByProperty(hql, loginname);
		return null != users && users.size() > 0 ? users.get(0) : null;
	}

	

}
