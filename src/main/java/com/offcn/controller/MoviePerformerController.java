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
			//调用业务层方法--有当前页电影信息，又有当前页数字
		  PageInfo<Movie> pageInfo=	movieService.queryMovieList(currentPage,bean);
		  //查询条件的数据获取
		  
		List<String> cs=  categroyService.queryCategroys();
		  
		  
		  //送数据
			model.addAttribute("pageInfo",pageInfo );
			//下拉框中的依据--搜索条件
			List<String> list=new ArrayList<>();
			list.add("所有类型");
			list.addAll(cs);
			
			list.add("电影名称");
			model.addAttribute("list",list);
			
			//回显历史查询条件
			model.addAttribute("conditionBean",bean);

			return "/WEB-INF/views/movieperformer/movieshow.jsp";
		}
	//进入电影出演信息查看页面
	@RequestMapping("movie-performer-look")
	public String moviePerformerLook(int id,Model model) {
		//System.out.println(id);
		
	List<MoviePerformer> mps =moviePerformerService.queryMoviePerformerByMovieId(id);
		model.addAttribute("mperformers",mps );
		
		return "/WEB-INF/views/movieperformer/performershow.jsp";
	}
	
	//进入电影参演人员编辑页面
	@RequestMapping("movie-performer-edit")
	public String moviePerformerEdit(int id,Model model) {
		
	//	System.out.println(id);
		List<MoviePerformer> mperformers = moviePerformerService.queryMoviePerformerByMovieId(id);
		
		model.addAttribute("mperformers", mperformers)	;
		
		return  "/WEB-INF/views/movieperformer/performeredit.jsp";	
	}
	
	//实现出演人员编辑功能
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
