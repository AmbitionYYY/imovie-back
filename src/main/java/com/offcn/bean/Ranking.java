package com.offcn.bean;
//此类用来保存排名数据
public class Ranking {

	//排名中有几个列，这就有几个属性
	private String name;
	private Integer num;
	private Float avgscore;
	private Float percent;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Integer getNum() {
		return num;
	}
	public void setNum(Integer num) {
		this.num = num;
	}
	public Float getAvgscore() {
		return avgscore;
	}
	public void setAvgscore(Float avgscore) {
		this.avgscore = avgscore;
	}
	public Float getPercent() {
		return percent;
	}
	public void setPercent(Float percent) {
		this.percent = percent;
	}
	
}
