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
	
	//����
	@Autowired
	private MovieDao movieDao;
	@Autowired
	private PerformerDao PerformerDao;
	@Autowired
	private UserDao userDao;
	@Autowired 
	private CategroyDao categroyDao;
	@Autowired
	private RankingDao rankingDao;//û��ר�ŵı���֮��Ӧ
	@Autowired
	private LogDao logDao;
	
	
	//��ѯͳ�ƽ�����������
	@Override
	public DataBean querydata() {
		//���������ݣ��������ݣ��б�����
		//�������ݣ���Ӱ����Ա���û�������
		int	movienum=movieDao.selectCount();
		int performernum=PerformerDao.selectCount();
		int usernum= userDao.selectCount();
		int categroynum=categroyDao.selectCount();
		
		//�б����ݣ������б���־�б�
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
