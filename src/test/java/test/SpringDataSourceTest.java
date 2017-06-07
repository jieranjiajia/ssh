package test;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.study.dao.impl.UserDAOImpl;
import org.study.model.User;

public class SpringDataSourceTest extends BaseTest{

	@Autowired
	private UserDAOImpl userDAO;
	
	@Test
	public void test() {
		User user = userDAO.getById(1);
		System.out.println(user);
	}
}
