package org.study.shiro;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.util.Assert;
import org.study.common.utils.DigestUtils;

/**
 * 用于配置shiro的密码加密配置
 */
public class PasswordHash implements InitializingBean{

	/**
	 * 加密的算法名：
	 * MD5、SHA-1、SHA-256、SHA-384、SHA-512
	 */
	private String algorithmName;
	
	/** 密码迭代次数 */
	private int hashIterations; 
	
	public String getAlgorithmName() {
		return algorithmName;
	}

	public void setAlgorithmName(String algorithmName) {
		this.algorithmName = algorithmName;
	}

	public int getHashIterations() {
		return hashIterations;
	}

	public void setHashIterations(int hashIterations) {
		this.hashIterations = hashIterations;
	}

	/* 
	 * @see org.springframework.beans.factory.InitializingBean#afterPropertiesSet()
	 */
	@Override
	public void afterPropertiesSet() throws Exception {
		Assert.notNull(algorithmName,"algorithmName mast be MD5、SHA-1、SHA-256、SHA-384、SHA-512");
	}
	
	/**
	 * 对一个数据进行加密
	 */
	public String toHex(Object source, Object salt) {
		return DigestUtils.hashByShiro(getAlgorithmName(), source, salt, getHashIterations());
	}
	
}
