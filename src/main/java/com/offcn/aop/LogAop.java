package com.offcn.aop;

import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.beans.factory.annotation.Autowired;

import com.offcn.bean.Log;
import com.offcn.service.LogService;

//切面类，保存着增强功能
@Aspect
public class LogAop {	
	@Autowired
	private LogService logService;
	@Autowired
	private HttpSession session;
	@Autowired
	private HttpServletRequest request;
	
	//前通知--在controller的方法执行之前进行切入
	@Before("execution(* com.offcn.controller.*.*(..))")
	public void before() {
	//	System.out.println("123..");
	
		//访问时间
		Date date=new Date();
		//访问用户
		String  name = (String) session.getAttribute("username");
		//访问路径
		String uri= request.getRequestURI();
		//访问地址
		String ip = request.getRemoteAddr();
		
		Log log =new Log();
		log.setLogdate(date);
		log.setLogip(ip);
		log.setLogurl(uri);
		log.setLogusername(name);
		
		logService.save(log);
	}
}
