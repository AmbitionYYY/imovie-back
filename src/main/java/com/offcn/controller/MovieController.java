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
	//����
	@Autowired
	private MovieService movieService;
	@Autowired
	private CategroyService categroyService;
	
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

		return "/WEB-INF/views/movie/movieshow.jsp";
	}
	
	
	//�����Ӱ¼�����
	@RequestMapping("movie-add-show")
	public	String movieAddShow() {
		
		return "/WEB-INF/views/movie/movieadd.jsp";
	}
	//�������ܵ�ʵ��
	@RequestMapping("movie-add")
	public String movieAdd(Movie movie,MovieDetail moviedetail,MultipartFile files) throws IllegalStateException, IOException {
		
	//	System.out.println(movie);
	//	System.out.println(moviedetail);
		if(files!=null && !files.isEmpty()) {
			String oname = files.getOriginalFilename();
			//System.out.println(oname);
			//���ļ�������--����ַ���
			int index = oname.lastIndexOf(".");
			String extname="";
			if(index!=-1) {
				extname=oname.substring(index);
			}
			String nname=UUID.randomUUID().toString().replaceAll("-", "")+extname;
			//����Ӱ������	��ֵ
			movie.setSaveimagepath("/photo/"+nname);
			
			//ָ������λ��
			File file =new File("F:\\2020ѧϰ�ĵ�\\photo",nname);
			files.transferTo(file);
		}
		movie.setStatus(1);
		movie.setSource("imovie");
		
		//������󴫵�service ,dao
		movieService.save(movie,moviedetail);
		//������֮��ȥ���б�ҳ��
		return "redirect:/movie/movie-show";
	}
	//����༭ҳ��
	@RequestMapping("movie-edit-show")
	public String movieEditShow(int id,Model model) {
	//	System.out.println(id);
		//��ԭ����
		Movie movie=movieService.queryMovieById(id);
		//��ҳ�������ݣ����͵�Ӱ����������������
		//movie�а�������
		model.addAttribute("movie", movie);
		
		return "/WEB-INF/views/movie/movieedit.jsp";
	}
	
	//�޸Ĺ��ܵ�ʵ��
	@RequestMapping("movie-edit")
	public String movieEdit(Movie movie,MovieDetail moviedetail,MultipartFile files) throws IllegalStateException, IOException {
			
		//�����������޸�imagepathֵ��������ִ���ڲ�����ʵ��ͼƬ�ϴ�
		if(files!=null &&!files.isEmpty()) {
			String oname = files.getOriginalFilename();
			int index = oname.lastIndexOf(".");
			String extname="";
			if(index!=-1) {
				extname=oname.substring(index);
			}
			String nname=UUID.randomUUID().toString().replaceAll("-", "")+extname;
			//����Ӱ��������ֵ
			movie.setSaveimagepath("/photo/"+nname);
			
			//ָ������λ��
			File file =new File("F:\\2020ѧϰ�ĵ�\\photo",nname);
			files.transferTo(file);
		}
			movie.setStatus(1);
			movie.setSource("imovie");
		
		movieService.edit(movie,moviedetail);
		return "redirect:/movie/movie-show";
		
	}
	//������˽���
	@RequestMapping("movie-audit-show")
	public String movieAuditShow(int id,Model model) {
		Movie movie=movieService.queryMovieById(id);
		model.addAttribute("movie",movie);
		return "/WEB-INF/views/movie/movieaudit.jsp";
		
	}
	//��˹���ʵ��
	@RequestMapping("movie-audit")
	public String movieAudit(int id,int status) {
		
	//	System.out.println(id+"==="+status);
		movieService.audit(id,status);
		return "redirect:/movie/movie-show";
	}
	//ɾ�����ܵ�ʵ��
	@RequestMapping("movie-delete")
	public String movieDelete(int id) {
	//	System.out.println(id);
		movieService.deleteMovie(id);
		
		//ɾ����ص��б�ҳ
		return "redirect:/movie/movie-show";
	}
	
	
}