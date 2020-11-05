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

	// �û���ʾ
	@RequestMapping("user-show")
	public String userShow(Model model) {

		List<User> users = userService.queryUserAll();
		model.addAttribute("users", users);
		return "/WEB-INF/views/user/usershow.jsp";

	}

	// ����ע�����
	@RequestMapping("user-register-show")
	public String userRegisterShow(Model model) {
		User user=new User();
		model.addAttribute("user",user);

		return "/WEB-INF/views/user/userregister.jsp";
	}

	// �����¼����
	@RequestMapping("user-login-show")
	public String userLoginShow(@ModelAttribute("flag") String flag,Model model){
		model.addAttribute("flag", flag);
		return "/login.jsp";
	}


	// ����û����Ƿ����
	@RequestMapping("check-username")
	@ResponseBody
	public Map<String,Object> checkUsername(String name){
		System.out.println(name);
		//����service,service����dao,��ɼ�飬�ͻؽ��
		
	boolean bo= userService.queryUserByUsername(name);
		Map<String,Object> map= new HashMap<>();
	
		if(bo) {
			map.put("key",true);
		
	}else {
		map.put("key",false);
		}
		return map;
			
	}
	
	//ʵ��ע��
	@RequestMapping("user-register")
	//Validatedע���Errorsȱһ���ɣ����ұ�������
	public String userRegister(@Validated User user,Errors errors,Model model) {
		System.out.println(user.getUsername()+"--"+user.getPassword());
		//У������ӡ���
//		for(ObjectError oe:errors.getAllErrors()) {
//			System.out.println(oe.getDefaultMessage());
//		}
		
		//��У����Ϣ��ص�ע��ҳ�棬������ҳ����ʾ��û����Ϣ������ִ�����ע�Ṧ��
		if(errors.hasErrors()) {
			
			//��У����Ϣ��ȥ
			model.addAttribute("errors",errors.getAllErrors());
			model.addAttribute("user",user);
			return "/WEB-INF/views/user/userregister.jsp";
		}else {
			//ע��ɹ���ע��ʧ��
			//ע��--��������
			userService.save(user);
		}
		
		//ע��ɹ���ע��ʧ��
		return "redirect:/user/user-login-show";
	}
	
	//��¼����ʵ��
	@RequestMapping("login")
	public String login(User user,RedirectAttributes attribute,HttpSession session) {
		System.out.println(user.getUsername() + "--" + user.getPassword());
		User us = userService.queryUserByNameAndPassword(user);
		if(us!=null) {
			//���Ի�ȡ���û�������ô���԰��û����ŵ�session�С�cookie�������湦�ܵĿ��
			session.setAttribute("username", us.getUsername());
			
			//��½�ɹ�---������ҳ
			return "redirect:/main/main-show";
		}else {
			//��¼ʧ��---�ص���¼ҳ
			attribute.addFlashAttribute("flag", "1");
			//ͨ��flag=1����ǵ�¼ʧ��
			return "redirect:/user/user-login-show";
		}	
	}
	//�ǳ�����ʵ��
	@RequestMapping("logout")
	public String logout(HttpSession session){
		//�ڵǳ�������ʱ����Ҫ�Ա����û��Ĳ���������������session����cookie������Чʱ�䣬����������
		session.invalidate();
		
		//�ǳ�֮��ص�¼ҳ
		return "redirect:/user/user-login-show";
	}
	
	
	
	
	//�޸�����ҳ��
	@RequestMapping("edituser-show")
	public String editUserShow(User user) {
				
		return "/WEB-INF/views/user/edituser.jsp";	
	}
	
	//�޸����빦��ʵ��
	@RequestMapping("edituser")
	public String editUser(@ModelAttribute("user")User user,Model model) {
		
		System.out.println(user.getUsername()+"--"+user.getPassword());
		userService.update(user);
		
		return "/WEB-INF/views/main/main.jsp";
	}
	
}