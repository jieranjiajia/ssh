package org.study.common.utils;

public class StringUtils {
	
	
	public static boolean isBlank(String s) {
		return (null == s) || s.trim().length() == 0; 
	}
	
	public static boolean isNotBlank(String s) {
		return !(isBlank(s));
	}

}
