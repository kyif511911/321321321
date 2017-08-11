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
		
		//�������͹���������ȷ����û��username��Ӧ��ֵ
		HttpSession session=request.getSession();
		
		String name=(String) session.getAttribute("username");
		
		//��name����ֵ��˵��session�д������û���Ϣ�������������ͨ��
		if(name!=null){
			return true;
		}else{
		
		//���û�У���ת����½����
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
