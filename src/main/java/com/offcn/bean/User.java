package com.offcn.bean;

import javax.validation.constraints.Pattern;

public class User {
	private Integer id;
	//校验注解使用正则表达式进行校验
	@Pattern(regexp="^[a-zA-Z0-9_-]{4,16}$",message="用户名正则，4到16位（字母，数字，下划线，减号）")
	private String username;
	//校验注解
	@Pattern(regexp="^.*(?=.{6,})(?=.*\\d)(?=.*[A-Z])(?=.*[a-z])(?=.*[!@#$%^&*? ]).*$",message="最少6位，包括至少1个大写字母，1个小写字母，1个数字，1个特殊字符")
	private String password;
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
}
