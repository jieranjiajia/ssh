package org.study.shiro;

import java.util.Set;

import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.study.model.User;
import org.study.service.ResourceService;
import org.study.service.UserService;

public class ShiroDBRealm extends AuthorizingRealm {
	
	protected static final Logger log = LoggerFactory.getLogger(ShiroDBRealm.class);
	
	/** 注入service服务 */
	@Autowired UserService userService;
	@Autowired ResourceService resourceService;
	
	/** 
	 * shiro的授权
	 */
	@Override
	protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection arg0) {
		// TODO Auto-generated method stub
		return null;
	}

	/**
	 * shiro的认证
	 * 认证的步骤。首先根据用户名查出一个用户，在拿用户输入的密码和数据库查出来的密码做一个匹配。
	 * 这个匹配操作由shiro来完成
	 */
	@Override
	protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
		if(log.isDebugEnabled()) {
			log.debug("shiro登录认证开始{}",token.getPrincipal());
		}
		UsernamePasswordToken uptoken = (UsernamePasswordToken)token;
		String loginName = uptoken.getUsername();
		User user = userService.getUserByLoginName(loginName);
		//账户不存在
		if(null == user) {
			return null;
		}
		//账户被锁定
		if(user.getStatus() != 0) {
			return null;
		}
		ShiroUser shiroUser = new ShiroUser(user);
		Set<String> urls = resourceService.getUrlsByUserid(shiroUser.getId());
		/*设置用户能够访问的URL*/
		shiroUser.setUrlSet(urls);
		
		return new SimpleAuthenticationInfo(shiroUser,      //认证身份
										user.getPassword(),   //认证凭证
										user.getSalt(),     //加密盐值
										getName());          //roleName
	}

}
