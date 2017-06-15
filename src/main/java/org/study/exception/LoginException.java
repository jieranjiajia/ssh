package org.study.exception;

/**
 * 定义登录异常类
 */
public class LoginException extends RuntimeException {

	/** */
	private static final long serialVersionUID = 1L;

	private String message;
	private Throwable e;
	
	
	public LoginException(){}
	
	public LoginException(String message) {
		super(message);
	}
	
	public LoginException(String message, Throwable e) {
		super(message,e);
	}
	
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public Throwable getE() {
		return e;
	}
	public void setE(Throwable e) {
		this.e = e;
	}
	
}
