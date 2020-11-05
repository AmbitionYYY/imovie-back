package com.offcn.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.offcn.bean.Movie;
import com.offcn.bean.Performer;
import com.offcn.service.MovieService;
import com.offcn.service.PerformerService;

@Controller
@RequestMapping("main")
public class MainController {

	//属性
	@Autowired
	private MovieService movieService;
	@Autowired
	private PerformerService performerService;
	@RequestMapping("main-show")
	public String mainShow(Model model) {
		//调用方法
		List<Movie> movies= movieService.queryMovieToMain();
		List<Performer> performers= performerService.queryPerformerToMain();

		
		//送数据回去---一部分电影数据，一部分演员数据
		model.addAttribute("movies",movies);//电影
		model.addAttribute("performers",performers);//演员

		return "/WEB-INF/views/main/main.jsp";
	}
}
