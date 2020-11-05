package com.offcn.service;

import java.util.List;

import com.offcn.bean.MoviePerformer;
import com.offcn.bean.ParameterBean;

public interface MoviePerformerService {
	
	public List<MoviePerformer> queryMoviePerformerByMovieId(int id);

	public void edit(ParameterBean bean);
}
