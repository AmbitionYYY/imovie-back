package com.offcn.bean;

import java.util.List;

//保存参数
public class ParameterBean {

	
	//表单隐藏框的id值  mid的值
	private Integer mid;
	//页面中很多行数据值
	private List<MoviePerformer> list;
	public Integer getMid() {
		return mid;
	}
	public void setMid(Integer mid) {
		this.mid = mid;
	}
	public List<MoviePerformer> getList() {
		return list;
	}
	public void setList(List<MoviePerformer> list) {
		this.list = list;
	}
	

}
