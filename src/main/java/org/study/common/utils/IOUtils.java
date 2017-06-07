package org.study.common.utils;

import java.io.Closeable;
import java.io.IOException;


public class IOUtils {

	public static void closeStream(Closeable io) {
		if(null != io) {
			try {
				io.close();
			} catch (IOException e) {
				throw new RuntimeException(e);
			}
		}
	}
	
	
}
