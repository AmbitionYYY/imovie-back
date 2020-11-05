package com.offcn.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.offcn.bean.MoviePerformer;
import com.offcn.bean.ParameterBean;
import com.offcn.dao.MoviePerformerDao;
@Service
public class MoviePerformerServiceImpl implements MoviePerformerService {

	@Autowired
	private MoviePerformerDao moviePerformerDao;
	//按照电影id查出演

	@Override
	public List<MoviePerformer> queryMoviePerformerByMovieId(int id) {
		
		List<MoviePerformer> mps=	moviePerformerDao.selectMoviePerformerByMovieId(id);	
		return mps;
	}
	
	//电影出演的编辑
	@Transactional
	@Override
	public void edit(ParameterBean bean) {
		//加入页面中所有出演项全部删除，信息不保留
		//页面中出演信息数量不变，文本框中数据改变
		//直接删除了一部分，但有所保留
		//原来的数据没变，又追加了新项
		//删了一部分又追加了新项
		
		
		
		//先按照id删除
		moviePerformerDao.deleteById(bean.getMid());
		//对送来的集合进行判断，有数据删了重插，没数据不动
		if(bean.getList()!=null&&bean.getList().size()>0) {
			for(MoviePerformer mp:bean.getList()) {		
				moviePerformerDao.insert(mp);
			}
		}
	}

}
