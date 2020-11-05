package com.offcn.service;

import java.util.List;

import com.offcn.bean.User;

public interface UserService {
	public List<User> queryUserAll();
	public boolean queryUserByUsername(String name);
	public void save(User user);
	public User queryUserByNameAndPassword(User u);
	public void update(User user);
}
