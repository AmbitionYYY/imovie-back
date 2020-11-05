package com.offcn.dao;

import com.offcn.bean.MovieDetail;

public interface MoviedetailDao {
public void insert(MovieDetail moviedetail);
public MovieDetail selectMovieDetailById(int id);
public void update(MovieDetail moviedetail);
public void deleteById(int id);
}
