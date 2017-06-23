package org.study.common.utils;

import org.apache.commons.lang3.StringUtils;
import org.apache.shiro.crypto.hash.SimpleHash;

/**
 * 密码加密工具类
 */
public class DigestUtils {

	/** 默认的加密形式MD5加密  */
	private static final String DEFAULT_ALGORITHM_NAME = "MD5";
	/** 默认加密的次数为5次 */
	private static final int DEFAULT_HASHITERATIONS = 5;
	
	/**
	 * 
	 * @param algorithmName    算法
	 * @param source		       源值
	 * @param salt             盐值
	 * @param hashIterations   次数
	 * @return				       加密后的字符串
	 */
	public static String hashByShiro(String algorithmName, Object source, Object salt, int hashIterations) {
		return new SimpleHash(StringUtils.isNotBlank(algorithmName) ? algorithmName : DEFAULT_ALGORITHM_NAME, 
				source, 
				salt, 
				Math.max(DEFAULT_HASHITERATIONS, hashIterations)
				).toHex();
	}
	
	public static void main(String[] args) {
		String hashByShiro = DigestUtils.hashByShiro("MD5", "123456", "testoqs", 5);
		System.out.println(hashByShiro);
	}
	
}
