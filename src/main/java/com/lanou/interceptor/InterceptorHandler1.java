package com.lanou.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

public class InterceptorHandler1 extends HandlerInterceptorAdapter {
	//适配器模式：为了防止借口冲突
	//适配器类主动实现了相关借口的方法。
	//在使用中，集成适配器类创建子类使用
	//子类可以自己决定重写那些方法，而不是全部实现所有的接口方法
	
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		// 在请求发来的时候 还未开始处理，就已经执行这个方法
		//true:请求通过
		//flase：不通过
		System.out.println("interceptor1---preHandle");
		return true;
	}

	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
		
		
		// 处理请求之后执行这个方法
		System.out.println("interceptor1---postHandle");
	}

	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
			throws Exception {
		// 请求处理完成所执行这个方法
		System.out.println("interceptor1---afterHandle");
	}
	

	
	

}
