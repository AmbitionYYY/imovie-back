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
	
	//�����û�����ѯ�û��Ƿ���ڣ��û�ע����֤�û����Ƿ����
	@Override
	public boolean queryUserByUsername(String name) {
		User user=userDao.selectUserByUsername(name);
		if(user!=null) return true;
		return false;
	
	}

	//���湦�ܣ���ɾ�Ķ�Ҫ������ע�⣩
	@Transactional
	@Override
	public void save(User user) {
		userDao.insert(user);
		
	}
//��¼��ѯ�������û����������ѯ
	@Override
	public User queryUserByNameAndPassword(User u) {
		//�Ȱ����û����飬���û�в鵽��--��½ʧ�ܣ��������ж����룩������鵽���ж�����
	User us=userDao.selectUserByUsername(u.getUsername());
	//�����Ʋ鵽��
	if(us!=null) {
		//�ж�����
	String password=	us.getPassword();
	if(password.equals(u.getPassword())) {
		us.setPassword("");//��Ϊ�������
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
