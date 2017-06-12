package org.study.dao;

public interface UserDAO<User> extends BaseDAO<User> {

	User getUserByName(String loginname);
	
	
}
