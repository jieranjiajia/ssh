package org.study.dao;

import org.study.model.User;

public interface UserDAO extends BaseDAO<User> {

	User getUserByName(String loginname);
	
}
