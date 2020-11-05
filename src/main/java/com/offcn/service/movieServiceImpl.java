package com.offcn.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.offcn.bean.ConditionBean;
import com.offcn.bean.Movie;
import com.offcn.bean.MovieDetail;
import com.offcn.dao.MovieDao;
import com.offcn.dao.MoviePerformerDao;
import com.offcn.dao.MoviedetailDao;

@Service
public class movieServiceImpl implements MovieService {

	
	//属性
	@Autowired
	private MovieDao movieDao;
	@Autowired MoviedetailDao moviedetailDao;
	@Autowired MoviePerformerDao moviePerformerDao;
	
	@Override
	public List<Movie> queryMovieToMain() {
		
		List<Movie> ms=	movieDao.selectMovieToMain();
		return ms;
	}
	
	//实现分页
	@Override
	public PageInfo<Movie> queryMovieList(int currentPage,ConditionBean bean) {
		// 插件的使用必须遵循顺序
		//设置当前页和每页条数
		PageHelper.startPage(currentPage, 15);
		//设置持久层方法查询,在bean中包含两种情况；要么没有条件，要么有条件
	List<Movie> ms=movieDao.selectMovieList(bean);
	//设置pageinfo对象,第二个参数是页码上显示的数字
	PageInfo<Movie>  pageInfo=new 	PageInfo<>(ms,10);
		return pageInfo;
	}

	//保存电影和详情
	@Transactional
	@Override
	public void save(Movie movie, MovieDetail moviedetail) {
		
		movieDao.insert(movie);
		Integer id = movie.getId();
		moviedetail.setId(id);    //传id
		moviedetailDao.insert(moviedetail);
	}

	
	//按id查电影，包含详情
	@Override
	public Movie queryMovieById(int id) {
		// TODO Auto-generated method stub
		//先查电影
	Movie movie=	movieDao.selectMovieById(id);
	//在查详情
	MovieDetail moviedetail = moviedetailDao.selectMovieDetailById(id);
	movie.setMoviedetail(moviedetail);
		return movie;
	}

	
	//修改电影修改详情
	//事务注解
	@Transactional
	@Override
	public void edit(Movie movie, MovieDetail moviedetail) {
		movieDao.update(movie);
		moviedetailDao.update(moviedetail);
		
	}
//按id实现修改状态
	@Transactional
	@Override
	public void audit(int id, int status) {
		// TODO Auto-generated method stub
		movieDao.audit(id,status);
		
	}
	//删除功能的实现
	@Transactional
	@Override
	public void deleteMovie(int id) {
//所以有关的关联数据是否都需要删除，如果有外键约束，那么外键制约主键表的删除
		//当前都需要删除，从外键表删除到主键表删除
		//movietable,moviedetailtable,movieperformertable,movieurl四个表需要删除
		//哪个是外键表，哪个是主键表movietable为主其余的为从
		moviedetailDao.deleteById(id);
		moviePerformerDao.deleteById(id);
		movieDao.deleteById(id);
		
		
		
	}

}
