package com.offcn.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.offcn.dao.CategroyDao;
@Service
public class CategroyServiceImpl implements CategroyService {

	
	//��ѯһ����������
	
	@Autowired
	private CategroyDao categroyDao;
	@Override
	public List<String> queryCategroys() {
		// TODO Auto-generated method stub
	List<String> cs=	categroyDao.selectCategroys();
		return cs;
	}

}
