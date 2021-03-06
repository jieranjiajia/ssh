package org.study.shiro;

import java.util.Set;

import javax.annotation.PostConstruct;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.authc.credential.CredentialsMatcher;
import org.apache.shiro.authc.credential.HashedCredentialsMatcher;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.session.Session;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.util.SimpleByteSource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.study.common.Contants;
import org.study.model.User;
import org.study.service.ResourceService;
import org.study.service.UserService;

/**
 * 实现自定义的shiro认证realm
 */
public class ShiroDBRealm extends AuthorizingRealm {
	
	protected static final Logger log = LoggerFactory.getLogger(ShiroDBRealm.class);
	
	/** 注入service服务 */
	@Autowired UserService userService;
	@Autowired ResourceService resourceService;
	
	@Autowired private PasswordHash passwordHash;
	
	/**
	 * 无参构造方法
	 */
	public ShiroDBRealm() {	}
	
	/**
	 * 带有凭证认证器的构造方法
	 * @param matcher
	 */
	public ShiroDBRealm(CredentialsMatcher matcher) {
		super(matcher);
	}
	
	/** 
	 * shiro的授权
	 */
	@Override
	protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
		ShiroUser shiroUser = (ShiroUser)principals.getPrimaryPrincipal();
		SimpleAuthorizationInfo info = new SimpleAuthorizationInfo(shiroUser.getRoles());
		info.addStringPermissions(shiroUser.getUrlSet());
		return info;
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
		//通过数据库查询出来的user来构造一个shiro中可以携带更多信息的user
		ShiroUser shiroUser = new ShiroUser(user);
		Session session = SecurityUtils.getSubject().getSession();
		session.setAttribute(Contants.LOGIN_USER, shiroUser);
		Set<String> urls = resourceService.getUrlsByUserid(shiroUser.getId());
		/*设置用户能够访问的URL*/
		shiroUser.setUrlSet(urls);
		
		return new SimpleAuthenticationInfo(shiroUser,       //认证身份
										user.getPassword(),   //认证凭证
										new SimpleByteSource(user.getSalt() + user.getLoginName()),     //加密盐值
										getName());          //roleName
	}
	
	/**
	 * 设置密码匹配器
	 */
	@PostConstruct
	public void initCredentialsMatcher() {
		HashedCredentialsMatcher matcher = new HashedCredentialsMatcher(passwordHash.getAlgorithmName());
		matcher.setHashIterations(passwordHash.getHashIterations());
		super.setCredentialsMatcher(matcher);
	}
	
}
