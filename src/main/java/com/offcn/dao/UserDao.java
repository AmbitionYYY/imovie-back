package com.offcn.dao;

import java.util.List;

import com.offcn.bean.User;

public interface UserDao {

	public List<User> selectUserAll();

	public User selectUserByUsername(String name);

	public void insert(User user);

	public int selectCount();

	public void update(User user);
}
