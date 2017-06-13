package org.study.service;

import org.study.model.User;

public interface UserService {

	User getUserByLoginName(String loginName);
	
}
