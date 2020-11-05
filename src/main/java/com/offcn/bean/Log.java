package com.offcn.bean;

import java.util.Date;

public class Log {
	private Integer logid;
	private Date logdate;
	private String logusername;
	private String logurl;
	private String logip;
	public Integer getLogid() {
		return logid;
	}
	public void setLogid(Integer logid) {
		this.logid = logid;
	}
	
	
	public String getLogusername() {
		return logusername;
	}
	public void setLogusername(String logusername) {
		this.logusername = logusername;
	}
	public String getLogurl() {
		return logurl;
	}
	public void setLogurl(String logurl) {
		this.logurl = logurl;
	}
	public String getLogip() {
		return logip;
	}
	public void setLogip(String logip) {
		this.logip = logip;
	}
	public Date getLogdate() {
		return logdate;
	}
	public void setLogdate(Date logdate) {
		this.logdate = logdate;
	}
	
	
}
