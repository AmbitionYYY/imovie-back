package com.offcn.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.github.pagehelper.PageInfo;
import com.offcn.bean.ConditionBean;
import com.offcn.bean.Movie;

public interface MovieDao {

public List<Movie>	selectMovieToMain(); 
public List<Movie>  selectMovieList(ConditionBean bean);
public void insert(Movie movie);
public Movie selectMovieById(int id);
public void update(Movie movie);
public void audit(@Param("id")int id, @Param("status")int status);
public void deleteById(int id);
public int selectCount();
}
