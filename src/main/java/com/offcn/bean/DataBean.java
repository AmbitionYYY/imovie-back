package com.offcn.bean;

import java.util.List;



//���ౣ������ͳ�ƽ�������Ҫ����������
public class DataBean {
	//��Ӱ�ܸ���
	private Integer movienum;
	//��Ա�ܸ���
	private Integer performernum;
	//�û�����
	private Integer usernum;
	//��������
	private Integer categroynum;
	//����б�����
	private List<Ranking> rankings;
	private List<Log> logs;
	
	public Integer getMovienum() {
		return movienum;
	}
	public void setMovienum(Integer movienum) {
		this.movienum = movienum;
	}
	public Integer getPerformernum() {
		return performernum;
	}
	public void setPerformernum(Integer performernum) {
		this.performernum = performernum;
	}
	public Integer getUsernum() {
		return usernum;
	}
	public void setUsernum(Integer usernum) {
		this.usernum = usernum;
	}
	public Integer getCategroynum() {
		return categroynum;
	}
	public void setCategroynum(Integer categroynum) {
		this.categroynum = categroynum;
	}
	public List<Ranking> getRankings() {
		return rankings;
	}
	public void setRankings(List<Ranking> rankings) {
		this.rankings = rankings;
	}
	public List<Log> getLogs() {
		return logs;
	}
	public void setLogs(List<Log> logs) {
		this.logs = logs;
	}

	//����Ҫ����б�����
	

}
