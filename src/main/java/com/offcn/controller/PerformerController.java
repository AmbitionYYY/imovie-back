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
		//��ҳ��ҳ��
		PageInfo<Performer>  pageInfo= performerService.queryPerformerList(currentPage,bean);
				
				
		//�Ͳ�ѯ�б����ݻ�ȥ
		Map<String,String> map=new HashMap<>();
		
		map.put("'��ѯ����'","��ѯ����");
		map.put("name","����");
		map.put("sex","�Ա�");
		map.put("constellation","����");
		map.put("birthday","����");
		
		
		model.addAttribute("map", map);		
		model.addAttribute("pageInfo",pageInfo);//�б�����
		model.addAttribute("conditionBean",bean);	//��ʷ����	
		return "/WEB-INF/views/performer/performershow.jsp";
	}
	//�鿴��ϸ��Ա����
	@RequestMapping("performer-look-show")
	public String performerLookShow(String name,Model model) {
		
		Performer performer=performerService.queryPerformerByName(name);
		model.addAttribute("performer", performer);
		return "/WEB-INF/views/performer/performerdetail.jsp";
	}

}
