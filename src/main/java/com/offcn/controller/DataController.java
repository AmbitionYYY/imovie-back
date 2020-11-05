package com.offcn.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.offcn.bean.DataBean;
import com.offcn.service.DataService;

@Controller
	@RequestMapping("data")
	public class DataController {

	@Autowired
	private DataService  dataService;
		//显示统计界面
		@RequestMapping("data-show")
		public String dataShow(Model model){
			
		DataBean bean=dataService.querydata();
					
			//送数据回页面
			model.addAttribute("dataBean",bean);
			return "/WEB-INF/views/main/data.jsp";
		}
	}


