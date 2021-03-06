package test;

import java.util.List;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.study.model.Resource;
import org.study.model.User;
import org.study.service.ResourceService;
import org.study.service.UserService;

import com.alibaba.fastjson.JSON;

public class SpringDataSourceTest extends BaseTest{

	@Autowired private UserService userService;
	@Autowired private ResourceService resourceService;
		
	@Test
	public void test1() {
		String loginName="oqs";
		User user = userService.getUserByLoginName(loginName);
		System.out.println(user);
	}
	
	@Test
	public void test2() {
		List<Resource> resources = resourceService.getResourceByUserid(2);
		String jsonString = JSON.toJSONString(resources);
		System.out.println(jsonString);
	}
	
}
