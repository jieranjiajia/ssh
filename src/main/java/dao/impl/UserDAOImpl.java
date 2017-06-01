package dao.impl;

import org.springframework.stereotype.Repository;

import dao.UserDAO;
import model.User;

@Repository("uerDAO")
public class UserDAOImpl extends BaseDAOImpl<User> implements UserDAO<User> {

}
