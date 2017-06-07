package org.study.common.utils;

import org.apache.commons.lang3.StringUtils;
import org.apache.shiro.crypto.hash.SimpleHash;

/**
 * 加密工具类
 *
 */
public class DigestUtils {

	/**
	 * 默认的加密形式
	 */
	private static final String DEFAULT_ALGORITHM_NAME = "MD5";
	
	private static final int DEFAULT_HASHITERATIONS = 1;
	
	/**
	 * 
	 * @param algorithmName    算法
	 * @param source		       源值
	 * @param salt             盐值
	 * @param hashIterations   次数
	 * @return				       加密后的字符串
	 */
	public static String hashByShiro(String algorithmName, Object source, Object salt, int hashIterations) {
		return new SimpleHash(StringUtils.isNotBlank(algorithmName) ? algorithmName : DEFAULT_ALGORITHM_NAME, source, salt, Math.max(DEFAULT_HASHITERATIONS, hashIterations)).toHex();
	}
	
}
