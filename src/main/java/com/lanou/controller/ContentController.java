package com.lanou.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;




@Controller
public class ContentController {
	
	
	@RequestMapping(value="/")
	public String frontPage(){
		
		//低侵入式
		return "index";
	}
	
	
	//到登录页面
	@RequestMapping(value="/loginpage")
	public String loginPage(){
		return "loginpage";
	}
	
	//form表单请求
	@RequestMapping(value="/login")
	public String login(HttpServletRequest request, @RequestParam("username") String name,@RequestParam("password") String pwd){
		HttpSession session= request.getSession();
		
		session.setAttribute("username", name);
		
		//登录成功，重定向到userinfo页面
		return "redirect:userinfo";
	}
    
	//用户界面
	@RequestMapping(value="/userinfo")
	public String userinfoPage(){
		

		return "userinfo";
	}
	
	
	//登出
	@RequestMapping(value="/logout")
	public String logout(HttpServletRequest request){
		
		//登出就是清除session
		HttpSession session= request.getSession();
		
		session.invalidate();
		return "loginpage";
		
		
	}
	
	
	
	
	
	/*@RequestMapping(value="/findall")
	@ResponseBody
	public List<Message> findAllMsg(){
		
	  List<Message> messages=messageMapper.findAllMessages();
	  for(int i=0;i<10;i++){
		  Message message=new Message();
		  message.setContent("aaa");
		  message.setUp(i*17+13);
		  message.setDown(22);
		  message.setId(i*10);
		  messages.add(message);
		  
	  }
		
		return messages;
		
		
	}*/
   
}
