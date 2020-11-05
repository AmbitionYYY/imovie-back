package com.offcn.aop;

import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.beans.factory.annotation.Autowired;

import com.offcn.bean.Log;
import com.offcn.service.LogService;

//�����࣬��������ǿ����
@Aspect
public class LogAop {	
	@Autowired
	private LogService logService;
	@Autowired
	private HttpSession session;
	@Autowired
	private HttpServletRequest request;
	
	//ǰ֪ͨ--��controller�ķ���ִ��֮ǰ��������
	@Before("execution(* com.offcn.controller.*.*(..))")
	public void before() {
	//	System.out.println("123..");
	
		//����ʱ��
		Date date=new Date();
		//�����û�
		String  name = (String) session.getAttribute("username");
		//����·��
		String uri= request.getRequestURI();
		//���ʵ�ַ
		String ip = request.getRemoteAddr();
		
		Log log =new Log();
		log.setLogdate(date);
		log.setLogip(ip);
		log.setLogurl(uri);
		log.setLogusername(name);
		
		logService.save(log);
	}
}
