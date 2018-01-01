package com.guoxin.common.base;

import java.io.Serializable;

/**
 * 系统返回消息基础类
 * @author Rocye
 * @createTime 2016-12-05
 */
public class ResponseObj implements Serializable{
	private static final long serialVersionUID = 6894519253815766765L;
	
	private int errcode;		//错误码
	private String msg;			//信息
	
	/**
	 * 构造返回消息
	 */
	public ResponseObj() {
	}
	
	/**
	 * 构造返回消息
	 * @param errcode 错误码
	 * @param msg 提示信息	
	 */
	public ResponseObj(int errcode, String msg) {
		this.errcode = errcode;
		this.msg = msg;
	}
	
	/**
	 * 构造返回消息
	 * @param errcode 错误码
	 */
	public ResponseObj(int errcode) {
		this.errcode = errcode;
	}
	
	public int getErrcode() {
		return errcode;
	}
	public void setErrcode(int errcode) {
		this.errcode = errcode;
	}
	
	public String getMsg() {
		return msg;
	}
	public void setMsg(String msg) {
		this.msg = msg;
	}
	
}
