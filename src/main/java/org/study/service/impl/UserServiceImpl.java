package org.study.service.impl;


import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.study.dao.UserDAO;
import org.study.model.User;
import org.study.service.UserService;

@Service("userService")
public class UserServiceImpl implements UserService {
	
	@Resource(name="userDAO") private UserDAO userDAO;

	@Override
	public User getUserByLoginName(String loginName) {
		return userDAO.getUserByName(loginName);
	}

}
