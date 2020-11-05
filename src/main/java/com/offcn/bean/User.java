package com.offcn.bean;

import javax.validation.constraints.Pattern;

public class User {
	private Integer id;
	//У��ע��ʹ��������ʽ����У��
	@Pattern(regexp="^[a-zA-Z0-9_-]{4,16}$",message="�û�������4��16λ����ĸ�����֣��»��ߣ����ţ�")
	private String username;
	//У��ע��
	@Pattern(regexp="^.*(?=.{6,})(?=.*\\d)(?=.*[A-Z])(?=.*[a-z])(?=.*[!@#$%^&*? ]).*$",message="����6λ����������1����д��ĸ��1��Сд��ĸ��1�����֣�1�������ַ�")
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
