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

	
	//����
	@Autowired
	private MovieDao movieDao;
	@Autowired MoviedetailDao moviedetailDao;
	@Autowired MoviePerformerDao moviePerformerDao;
	
	@Override
	public List<Movie> queryMovieToMain() {
		
		List<Movie> ms=	movieDao.selectMovieToMain();
		return ms;
	}
	
	//ʵ�ַ�ҳ
	@Override
	public PageInfo<Movie> queryMovieList(int currentPage,ConditionBean bean) {
		// �����ʹ�ñ�����ѭ˳��
		//���õ�ǰҳ��ÿҳ����
		PageHelper.startPage(currentPage, 15);
		//���ó־ò㷽����ѯ,��bean�а������������Ҫôû��������Ҫô������
	List<Movie> ms=movieDao.selectMovieList(bean);
	//����pageinfo����,�ڶ���������ҳ������ʾ������
	PageInfo<Movie>  pageInfo=new 	PageInfo<>(ms,10);
		return pageInfo;
	}

	//�����Ӱ������
	@Transactional
	@Override
	public void save(Movie movie, MovieDetail moviedetail) {
		
		movieDao.insert(movie);
		Integer id = movie.getId();
		moviedetail.setId(id);    //��id
		moviedetailDao.insert(moviedetail);
	}

	
	//��id���Ӱ����������
	@Override
	public Movie queryMovieById(int id) {
		// TODO Auto-generated method stub
		//�Ȳ��Ӱ
	Movie movie=	movieDao.selectMovieById(id);
	//�ڲ�����
	MovieDetail moviedetail = moviedetailDao.selectMovieDetailById(id);
	movie.setMoviedetail(moviedetail);
		return movie;
	}

	
	//�޸ĵ�Ӱ�޸�����
	//����ע��
	@Transactional
	@Override
	public void edit(Movie movie, MovieDetail moviedetail) {
		movieDao.update(movie);
		moviedetailDao.update(moviedetail);
		
	}
//��idʵ���޸�״̬
	@Transactional
	@Override
	public void audit(int id, int status) {
		// TODO Auto-generated method stub
		movieDao.audit(id,status);
		
	}
	//ɾ�����ܵ�ʵ��
	@Transactional
	@Override
	public void deleteMovie(int id) {
//�����йصĹ��������Ƿ���Ҫɾ������������Լ������ô�����Լ�������ɾ��
		//��ǰ����Ҫɾ�����������ɾ����������ɾ��
		//movietable,moviedetailtable,movieperformertable,movieurl�ĸ�����Ҫɾ��
		//�ĸ���������ĸ���������movietableΪ�������Ϊ��
		moviedetailDao.deleteById(id);
		moviePerformerDao.deleteById(id);
		movieDao.deleteById(id);
		
		
		
	}

}
