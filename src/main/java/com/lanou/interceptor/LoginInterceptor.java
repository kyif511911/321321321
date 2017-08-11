package com.lanou.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

public class LoginInterceptor implements HandlerInterceptor {

	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		// TODO Auto-generated method stub
		
		String url=request.getRequestURI();
		// /spring...//loginxxx
		System.out.println(url);		  
		if(url.indexOf("login")>0){
			return true;
			
		}
		
		//当请求发送过来，首先确认有没有username对应的值
		HttpSession session=request.getSession();
		
		String name=(String) session.getAttribute("username");
		
		//当name中有值，说明session中储存了用户信息，就让这次请求通过
		if(name!=null){
			return true;
		}else{
		
		//如果没有，跳转到登陆界面
		request.getRequestDispatcher("/WEB-INF/pages/loginpage.jsp").forward(request, response);;
		
	
		return false;}
	}

	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
		// TODO Auto-generated method stub

	}

	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
			throws Exception {
		// TODO Auto-generated method stub

	}

}
