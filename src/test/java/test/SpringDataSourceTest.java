package test;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import dao.impl.UserDAOImpl;
import model.User;


public class SpringDataSourceTest extends BaseTest{

	@Autowired
	private UserDAOImpl userDAO;
	
	@Test
	public void test() {
		User user = userDAO.getById(1);
		System.out.println(user);
	}
}
