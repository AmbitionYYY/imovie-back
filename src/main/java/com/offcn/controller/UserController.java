package com.offcn.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.offcn.bean.User;
import com.offcn.service.UserService;

@Controller
@RequestMapping("user")
public class UserController {
	@Autowired
	private UserService userService;

	// 用户显示
	@RequestMapping("user-show")
	public String userShow(Model model) {

		List<User> users = userService.queryUserAll();
		model.addAttribute("users", users);
		return "/WEB-INF/views/user/usershow.jsp";

	}

	// 进入注册界面
	@RequestMapping("user-register-show")
	public String userRegisterShow(Model model) {
		User user=new User();
		model.addAttribute("user",user);

		return "/WEB-INF/views/user/userregister.jsp";
	}

	// 进入登录界面
	@RequestMapping("user-login-show")
	public String userLoginShow(@ModelAttribute("flag") String flag,Model model){
		model.addAttribute("flag", flag);
		return "/login.jsp";
	}


	// 检查用户名是否存在
	@RequestMapping("check-username")
	@ResponseBody
	public Map<String,Object> checkUsername(String name){
		System.out.println(name);
		//调用service,service调用dao,完成检查，送回结果
		
	boolean bo= userService.queryUserByUsername(name);
		Map<String,Object> map= new HashMap<>();
	
		if(bo) {
			map.put("key",true);
		
	}else {
		map.put("key",false);
		}
		return map;
			
	}
	
	//实现注册
	@RequestMapping("user-register")
	//Validated注解和Errors缺一不可，而且必须相邻
	public String userRegister(@Validated User user,Errors errors,Model model) {
		System.out.println(user.getUsername()+"--"+user.getPassword());
		//校验结果打印输出
//		for(ObjectError oe:errors.getAllErrors()) {
//			System.out.println(oe.getDefaultMessage());
//		}
		
		//有校验信息则回到注册页面，并且在页面显示，没有信息则向下执行完成注册功能
		if(errors.hasErrors()) {
			
			//送校验信息回去
			model.addAttribute("errors",errors.getAllErrors());
			model.addAttribute("user",user);
			return "/WEB-INF/views/user/userregister.jsp";
		}else {
			//注册成功，注册失败
			//注册--保存数据
			userService.save(user);
		}
		
		//注册成功，注册失败
		return "redirect:/user/user-login-show";
	}
	
	//登录功能实现
	@RequestMapping("login")
	public String login(User user,RedirectAttributes attribute,HttpSession session) {
		System.out.println(user.getUsername() + "--" + user.getPassword());
		User us = userService.queryUserByNameAndPassword(user);
		if(us!=null) {
			//可以获取到用户名：那么可以把用户名放到session中、cookie、带缓存功能的框架
			session.setAttribute("username", us.getUsername());
			
			//登陆成功---进入主页
			return "redirect:/main/main-show";
		}else {
			//登录失败---回到登录页
			attribute.addFlashAttribute("flag", "1");
			//通过flag=1来标记登录失败
			return "redirect:/user/user-login-show";
		}	
	}
	//登出功能实现
	@RequestMapping("logout")
	public String logout(HttpSession session){
		//在登出操作的时候，需要对保存用户的操作进行清理，比如session清理，cookie设置有效时间，缓存框架清理
		session.invalidate();
		
		//登出之后回登录页
		return "redirect:/user/user-login-show";
	}
	
	
	
	
	//修改密码页面
	@RequestMapping("edituser-show")
	public String editUserShow(User user) {
				
		return "/WEB-INF/views/user/edituser.jsp";	
	}
	
	//修改密码功能实现
	@RequestMapping("edituser")
	public String editUser(@ModelAttribute("user")User user,Model model) {
		
		System.out.println(user.getUsername()+"--"+user.getPassword());
		userService.update(user);
		
		return "/WEB-INF/views/main/main.jsp";
	}
	
}