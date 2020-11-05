package com.offcn.bean;

import java.util.List;



//此类保存数据统计界面所需要的所有数据
public class DataBean {
	//电影总个数
	private Integer movienum;
	//演员总个数
	private Integer performernum;
	//用户总数
	private Integer usernum;
	//分类总数
	private Integer categroynum;
	//添加列表属性
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

	//还需要添加列表属性
	

}
