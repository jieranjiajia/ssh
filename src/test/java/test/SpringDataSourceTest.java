package test;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.study.model.User;
import org.study.service.UserService;

public class SpringDataSourceTest extends BaseTest{

	@Autowired private UserService userService;
	
		
	@Test
	public void test1() {
		String loginName="oqs";
		User user = userService.getUserByLoginName(loginName);
		System.out.println(user);
	}
	
}
