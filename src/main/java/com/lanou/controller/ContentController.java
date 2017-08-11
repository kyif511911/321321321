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
		
		//������ʽ
		return "index";
	}
	
	
	//����¼ҳ��
	@RequestMapping(value="/loginpage")
	public String loginPage(){
		return "loginpage";
	}
	
	//form������
	@RequestMapping(value="/login")
	public String login(HttpServletRequest request, @RequestParam("username") String name,@RequestParam("password") String pwd){
		HttpSession session= request.getSession();
		
		session.setAttribute("username", name);
		
		//��¼�ɹ����ض���userinfoҳ��
		return "redirect:userinfo";
	}
    
	//�û�����
	@RequestMapping(value="/userinfo")
	public String userinfoPage(){
		

		return "userinfo";
	}
	
	
	//�ǳ�
	@RequestMapping(value="/logout")
	public String logout(HttpServletRequest request){
		
		//�ǳ��������session
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
