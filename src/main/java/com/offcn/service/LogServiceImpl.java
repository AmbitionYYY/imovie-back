package com.offcn.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.offcn.bean.Log;
import com.offcn.dao.LogDao;
@Service
public class LogServiceImpl implements LogService {
	@Autowired
	private LogDao logDao;
	
	@Transactional
	@Override
	public void save(Log log) {
		// TODO Auto-generated method stub
		logDao.insert(log);
	}
	
	//Â¼ÈëÊý¾Ý
	
	

}
