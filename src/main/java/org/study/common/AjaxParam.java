package org.study.common;

import com.alibaba.fastjson.JSON;

/**
 * 封装ajax参数
 * 
 */
public class AjaxParam {
	
	/** 展示信息 */
	private String msg;
	/** 是否请求成功*/
	private boolean isSuccess;
	/** 携带的参数*/
	private Object param;
	
	public AjaxParam() {
		this("",false,null);
	}
	
	public AjaxParam(String msg, boolean isSuccess) {
		this(msg,isSuccess,null);
	}
	
	public AjaxParam(String msg, boolean isSuccess, Object param) {
		this.msg = msg;
		this.isSuccess = isSuccess;
		this.param = param;
	}
	
	//-------------------getter setter methods-------------------
	public String getMsg() {
		return msg;
	}
	public void setMsg(String msg) {
		this.msg = msg;
	}
	public boolean isSuccess() {
		return isSuccess;
	}
	public void setSuccess(boolean isSuccess) {
		this.isSuccess = isSuccess;
	}
	public Object getParam() {
		return param;
	}
	public void setParam(Object param) {
		this.param = param;
	}
	
	/**
	 * 将参数转为json格式的字符串
	 */
	public String toString() {
		return JSON.toJSONString(this);
	}
	
}
