package com.offcn.dao;

import java.util.List;

import com.offcn.bean.ConditionBean;
import com.offcn.bean.Performer;

public interface PerformerDao {
	
	public List<Performer> selectPerformerToMain();

	public List<Performer> selectPerformerList(ConditionBean bean);

	public Performer selectPerformerByName(String name);

	public int selectCount();
}
