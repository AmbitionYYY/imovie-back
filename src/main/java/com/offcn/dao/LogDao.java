package com.offcn.dao;

import java.util.List;

import com.offcn.bean.Log;

public interface LogDao {
	public void  insert(Log log);

	public List<Log> selectLogList();
}
