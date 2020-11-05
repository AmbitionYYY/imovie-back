package com.offcn.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.offcn.bean.DataBean;
import com.offcn.bean.Log;
import com.offcn.bean.Ranking;
import com.offcn.dao.CategroyDao;
import com.offcn.dao.LogDao;
import com.offcn.dao.MovieDao;
import com.offcn.dao.PerformerDao;
import com.offcn.dao.RankingDao;
import com.offcn.dao.UserDao;
@Service
public class DataServiceImpl implements DataService {
	
	//属性
	@Autowired
	private MovieDao movieDao;
	@Autowired
	private PerformerDao PerformerDao;
	@Autowired
	private UserDao userDao;
	@Autowired 
	private CategroyDao categroyDao;
	@Autowired
	private RankingDao rankingDao;//没有专门的表与之对应
	@Autowired
	private LogDao logDao;
	
	
	//查询统计界面所需数据
	@Override
	public DataBean querydata() {
		//两大类数据，总数数据，列表数据
		//总数数据：电影，演员，用户，分类
		int	movienum=movieDao.selectCount();
		int performernum=PerformerDao.selectCount();
		int usernum= userDao.selectCount();
		int categroynum=categroyDao.selectCount();
		
		//列表数据：排名列表，日志列表
		List<Ranking> rankings=rankingDao.selectRankingList();
		List<Log> logs= logDao.selectLogList();
		
		
		DataBean bean = new DataBean();
		bean.setMovienum(movienum);
		bean.setCategroynum(categroynum);
		bean.setPerformernum(performernum);
		bean.setUsernum(usernum);	
		bean.setRankings(rankings);
		
		bean.setLogs(logs);
		
		return bean;
	}

}
