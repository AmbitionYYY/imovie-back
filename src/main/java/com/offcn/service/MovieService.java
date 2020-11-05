package com.offcn.service;

import java.util.List;

import com.github.pagehelper.PageInfo;
import com.offcn.bean.ConditionBean;
import com.offcn.bean.Movie;
import com.offcn.bean.MovieDetail;

public interface MovieService {
	
public List<Movie> 	queryMovieToMain();

public   PageInfo<Movie> queryMovieList(int currentPage, ConditionBean bean);
public void save(Movie movie,MovieDetail moviedetail);

public Movie queryMovieById(int id);

public void edit(Movie movie, MovieDetail moviedetail);

public void audit(int id, int status);

public void deleteMovie(int id);
}
