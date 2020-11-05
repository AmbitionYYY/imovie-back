package com.offcn.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.github.pagehelper.PageInfo;
import com.offcn.bean.ConditionBean;
import com.offcn.bean.Performer;
import com.offcn.service.PerformerService;

@Controller
@RequestMapping("performer")
public class PerformerController {
	
	@Autowired
	private PerformerService performerService;
	
	@RequestMapping("performer-show")
	public String performerShow(@RequestParam(defaultValue ="1")int currentPage,ConditionBean bean , Model model) {
		//分页和页码
		PageInfo<Performer>  pageInfo= performerService.queryPerformerList(currentPage,bean);
				
				
		//送查询列表数据回去
		Map<String,String> map=new HashMap<>();
		
		map.put("'查询所有'","查询所有");
		map.put("name","姓名");
		map.put("sex","性别");
		map.put("constellation","星座");
		map.put("birthday","生日");
		
		
		model.addAttribute("map", map);		
		model.addAttribute("pageInfo",pageInfo);//列表数据
		model.addAttribute("conditionBean",bean);	//历史数据	
		return "/WEB-INF/views/performer/performershow.jsp";
	}
	//查看详细演员界面
	@RequestMapping("performer-look-show")
	public String performerLookShow(String name,Model model) {
		
		Performer performer=performerService.queryPerformerByName(name);
		model.addAttribute("performer", performer);
		return "/WEB-INF/views/performer/performerdetail.jsp";
	}

}
