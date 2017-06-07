package org.study.dao.impl;

import org.springframework.stereotype.Repository;
import org.study.dao.UserDAO;
import org.study.model.User;


@Repository("uerDAO")
public class UserDAOImpl extends BaseDAOImpl<User> implements UserDAO<User> {

}
