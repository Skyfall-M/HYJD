package com.model;

import java.io.Serializable;

public class User implements Serializable{
	
	private static final long serialVersionUID = 1L;
	/**
	 * 用户id
	 */
	private int id;
	/**
	 * 用户名
	 */
	private String username;
	/**
	 * 用户密码
	 */
	private String userpassword;
	/**
	 * 用户信息
	 */
	private String usermessage;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getUserpassword() {
		return userpassword;
	}
	public void setUserpassword(String userpassword) {
		this.userpassword = userpassword;
	}
	public String getUsermessage() {
		return usermessage;
	}
	public void setUsermessage(String usermessage) {
		this.usermessage = usermessage;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	

}
