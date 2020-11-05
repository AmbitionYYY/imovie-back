package com.offcn.controller;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.github.pagehelper.PageInfo;
import com.offcn.bean.ConditionBean;
import com.offcn.bean.Movie;
import com.offcn.bean.MovieDetail;
import com.offcn.service.CategroyService;
import com.offcn.service.MovieService;

@Controller
@RequestMapping("movie")
public class MovieController {
	//属性
	@Autowired
	private MovieService movieService;
	@Autowired
	private CategroyService categroyService;
	
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

		return "/WEB-INF/views/movie/movieshow.jsp";
	}
	
	
	//进入电影录入界面
	@RequestMapping("movie-add-show")
	public	String movieAddShow() {
		
		return "/WEB-INF/views/movie/movieadd.jsp";
	}
	//新增功能的实现
	@RequestMapping("movie-add")
	public String movieAdd(Movie movie,MovieDetail moviedetail,MultipartFile files) throws IllegalStateException, IOException {
		
	//	System.out.println(movie);
	//	System.out.println(moviedetail);
		if(files!=null && !files.isEmpty()) {
			String oname = files.getOriginalFilename();
			//System.out.println(oname);
			//给文件重命名--随机字符串
			int index = oname.lastIndexOf(".");
			String extname="";
			if(index!=-1) {
				extname=oname.substring(index);
			}
			String nname=UUID.randomUUID().toString().replaceAll("-", "")+extname;
			//给电影对象设	置值
			movie.setSaveimagepath("/photo/"+nname);
			
			//指定保存位置
			File file =new File("F:\\2020学习文档\\photo",nname);
			files.transferTo(file);
		}
		movie.setStatus(1);
		movie.setSource("imovie");
		
		//数据向后传递service ,dao
		movieService.save(movie,moviedetail);
		//添加完成之后去到列表页面
		return "redirect:/movie/movie-show";
	}
	//进入编辑页面
	@RequestMapping("movie-edit-show")
	public String movieEditShow(int id,Model model) {
	//	System.out.println(id);
		//查原数据
		Movie movie=movieService.queryMovieById(id);
		//网页面送数据，即送电影数据又送详情数据
		//movie中包含详情
		model.addAttribute("movie", movie);
		
		return "/WEB-INF/views/movie/movieedit.jsp";
	}
	
	//修改功能的实现
	@RequestMapping("movie-edit")
	public String movieEdit(Movie movie,MovieDetail moviedetail,MultipartFile files) throws IllegalStateException, IOException {
			
		//不成立，则不修改imagepath值，成立则执行内部代码实现图片上传
		if(files!=null &&!files.isEmpty()) {
			String oname = files.getOriginalFilename();
			int index = oname.lastIndexOf(".");
			String extname="";
			if(index!=-1) {
				extname=oname.substring(index);
			}
			String nname=UUID.randomUUID().toString().replaceAll("-", "")+extname;
			//给电影对象设置值
			movie.setSaveimagepath("/photo/"+nname);
			
			//指定保存位置
			File file =new File("F:\\2020学习文档\\photo",nname);
			files.transferTo(file);
		}
			movie.setStatus(1);
			movie.setSource("imovie");
		
		movieService.edit(movie,moviedetail);
		return "redirect:/movie/movie-show";
		
	}
	//进入审核界面
	@RequestMapping("movie-audit-show")
	public String movieAuditShow(int id,Model model) {
		Movie movie=movieService.queryMovieById(id);
		model.addAttribute("movie",movie);
		return "/WEB-INF/views/movie/movieaudit.jsp";
		
	}
	//审核功能实现
	@RequestMapping("movie-audit")
	public String movieAudit(int id,int status) {
		
	//	System.out.println(id+"==="+status);
		movieService.audit(id,status);
		return "redirect:/movie/movie-show";
	}
	//删除功能的实现
	@RequestMapping("movie-delete")
	public String movieDelete(int id) {
	//	System.out.println(id);
		movieService.deleteMovie(id);
		
		//删除后回到列表页
		return "redirect:/movie/movie-show";
	}
	
	
}