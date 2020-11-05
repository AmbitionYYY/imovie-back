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
	//���յ�Ӱid�����

	@Override
	public List<MoviePerformer> queryMoviePerformerByMovieId(int id) {
		
		List<MoviePerformer> mps=	moviePerformerDao.selectMoviePerformerByMovieId(id);	
		return mps;
	}
	
	//��Ӱ���ݵı༭
	@Transactional
	@Override
	public void edit(ParameterBean bean) {
		//����ҳ�������г�����ȫ��ɾ������Ϣ������
		//ҳ���г�����Ϣ�������䣬�ı��������ݸı�
		//ֱ��ɾ����һ���֣�����������
		//ԭ��������û�䣬��׷��������
		//ɾ��һ������׷��������
		
		
		
		//�Ȱ���idɾ��
		moviePerformerDao.deleteById(bean.getMid());
		//�������ļ��Ͻ����жϣ�������ɾ���ز壬û���ݲ���
		if(bean.getList()!=null&&bean.getList().size()>0) {
			for(MoviePerformer mp:bean.getList()) {		
				moviePerformerDao.insert(mp);
			}
		}
	}

}
