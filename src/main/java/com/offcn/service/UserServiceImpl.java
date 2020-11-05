package com.offcn.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.offcn.bean.User;
import com.offcn.dao.UserDao;

@Service
public class UserServiceImpl implements UserService{
	
	@Autowired
	private UserDao userDao;
	@Override
	public List<User> queryUserAll() {
		
		List<User> us=userDao.selectUserAll();
		return us;
	}
	
	//按照用户名查询用户是否存在，用户注册验证用户名是否存在
	@Override
	public boolean queryUserByUsername(String name) {
		User user=userDao.selectUserByUsername(name);
		if(user!=null) return true;
		return false;
	
	}

	//保存功能（增删改都要加事务注解）
	@Transactional
	@Override
	public void save(User user) {
		userDao.insert(user);
		
	}
//登录查询，按照用户名和密码查询
	@Override
	public User queryUserByNameAndPassword(User u) {
		//先按照用户名查，如果没有查到则--登陆失败（则无需判断密码），如果查到再判断密码
	User us=userDao.selectUserByUsername(u.getUsername());
	//按名称查到了
	if(us!=null) {
		//判断密码
	String password=	us.getPassword();
	if(password.equals(u.getPassword())) {
		us.setPassword("");//人为清空密码
		return us;
	}
	}
		return null;
	}

	@Override
	public void update(User user) {

		userDao.update(user);
	}

}
