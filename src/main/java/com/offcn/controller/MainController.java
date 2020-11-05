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

	//����
	@Autowired
	private MovieService movieService;
	@Autowired
	private PerformerService performerService;
	@RequestMapping("main-show")
	public String mainShow(Model model) {
		//���÷���
		List<Movie> movies= movieService.queryMovieToMain();
		List<Performer> performers= performerService.queryPerformerToMain();

		
		//�����ݻ�ȥ---һ���ֵ�Ӱ���ݣ�һ������Ա����
		model.addAttribute("movies",movies);//��Ӱ
		model.addAttribute("performers",performers);//��Ա

		return "/WEB-INF/views/main/main.jsp";
	}
}
