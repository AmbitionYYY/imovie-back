package com.offcn.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.offcn.bean.ConditionBean;
import com.offcn.bean.Performer;
import com.offcn.dao.PerformerDao;
@Service
public class PerformerServiceImpl implements PerformerService {

	@Autowired
	private PerformerDao performerDao;
	@Override
	public List<Performer> queryPerformerToMain() {
		// TODO Auto-generated method stub
	List<Performer> ps=	performerDao.selectPerformerToMain();
		return ps;
	}
	
	//查询演员列表
	
	@Override
	public PageInfo<Performer> queryPerformerList(int currentPage, ConditionBean bean) {

		PageHelper.startPage(currentPage,15);
		List<Performer> list=performerDao.selectPerformerList(bean);
		PageInfo<Performer> pageInfo=new PageInfo<>(list,10);
		return pageInfo;
	}
	@Override
	public Performer queryPerformerByName(String name) {
		
		Performer per = performerDao.selectPerformerByName(name);
		return per;

	}

}
