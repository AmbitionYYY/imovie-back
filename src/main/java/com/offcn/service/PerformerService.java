package com.offcn.service;

import java.util.List;

import com.github.pagehelper.PageInfo;
import com.offcn.bean.ConditionBean;
import com.offcn.bean.Performer;

public interface PerformerService {

public	List<Performer> queryPerformerToMain();
public  PageInfo<Performer> queryPerformerList(int currentPage,ConditionBean bean);
public Performer queryPerformerByName(String name);
}
