package com.offcn.controller;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.github.pagehelper.PageInfo;
import com.offcn.bean.ConditionBean;
import com.offcn.bean.Movie;
import com.offcn.bean.MoviePerformer;
import com.offcn.bean.ParameterBean;
import com.offcn.service.CategroyService;
import com.offcn.service.MoviePerformerService;
import com.offcn.service.MovieService;

@Controller
@RequestMapping("movieperformer")
public class MoviePerformerController {
	
	@Autowired
	private MovieService movieService;
	@Autowired
	private CategroyService categroyService;
	@Autowired 
	private MoviePerformerService moviePerformerService;
	
	
	@RequestMapping("movie-show")
	public String movieShow(@RequestParam(defaultValue= "1")int currentPage,ConditionBean bean,Model model) {
		//	System.out.println(bean);
			//����ҵ��㷽��--�е�ǰҳ��Ӱ��Ϣ�����е�ǰҳ����
		  PageInfo<Movie> pageInfo=	movieService.queryMovieList(currentPage,bean);
		  //��ѯ���������ݻ�ȡ
		  
		List<String> cs=  categroyService.queryCategroys();
		  
		  
		  //������
			model.addAttribute("pageInfo",pageInfo );
			//�������е�����--��������
			List<String> list=new ArrayList<>();
			list.add("��������");
			list.addAll(cs);
			
			list.add("��Ӱ����");
			model.addAttribute("list",list);
			
			//������ʷ��ѯ����
			model.addAttribute("conditionBean",bean);

			return "/WEB-INF/views/movieperformer/movieshow.jsp";
		}
	//�����Ӱ������Ϣ�鿴ҳ��
	@RequestMapping("movie-performer-look")
	public String moviePerformerLook(int id,Model model) {
		//System.out.println(id);
		
	List<MoviePerformer> mps =moviePerformerService.queryMoviePerformerByMovieId(id);
		model.addAttribute("mperformers",mps );
		
		return "/WEB-INF/views/movieperformer/performershow.jsp";
	}
	
	//�����Ӱ������Ա�༭ҳ��
	@RequestMapping("movie-performer-edit")
	public String moviePerformerEdit(int id,Model model) {
		
	//	System.out.println(id);
		List<MoviePerformer> mperformers = moviePerformerService.queryMoviePerformerByMovieId(id);
		
		model.addAttribute("mperformers", mperformers)	;
		
		return  "/WEB-INF/views/movieperformer/performeredit.jsp";	
	}
	
	//ʵ�ֳ�����Ա�༭����
	@RequestMapping("performer-edit")
	public String 	performerEdit(ParameterBean bean) {
		/*System.out.println(bean.getMid());
		if(bean.getList()!=null&&bean.getList().size()>0) {
			for(MoviePerformer mp:bean.getList()) {
				System.out.println(mp.getId()+"--"+mp.getPerformer()+"--"+mp.getRole());
			}
		System.out.println("****************************");*/
		moviePerformerService.edit(bean);
		
		
		return "redirect:/movieperformer/movie-show";
	}
	
}
