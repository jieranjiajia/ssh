package org.study.shiro;

import org.apache.shiro.authc.credential.HashedCredentialsMatcher;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.util.Assert;

public class MyCredentialsMatcher extends HashedCredentialsMatcher 
								implements InitializingBean{

	
	/** shiro密码生成 */
	private PasswordHash passwordHash;

	public MyCredentialsMatcher(PasswordHash passwordHash) {
		this.passwordHash = passwordHash;
	}
	

	@Override
	public void afterPropertiesSet() throws Exception {
		Assert.notNull(passwordHash,"密码生成器不能为null");
		super.setHashAlgorithmName(passwordHash.getAlgorithmName());
		super.setHashIterations(passwordHash.getHashIterations());
	}
	
}
