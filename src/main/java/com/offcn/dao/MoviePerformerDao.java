package com.offcn.dao;

import java.util.List;

import com.offcn.bean.MoviePerformer;

public interface MoviePerformerDao {

public	void deleteById(int id);

public List<MoviePerformer> selectMoviePerformerByMovieId(int id);

public void insert(MoviePerformer movieperformer);

}
