package com.lanou.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

public class InterceptorHandler1 extends HandlerInterceptorAdapter {
	//������ģʽ��Ϊ�˷�ֹ��ڳ�ͻ
	//������������ʵ������ؽ�ڵķ�����
	//��ʹ���У������������ഴ������ʹ��
	//��������Լ�������д��Щ������������ȫ��ʵ�����еĽӿڷ���
	
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		// ����������ʱ�� ��δ��ʼ�������Ѿ�ִ���������
		//true:����ͨ��
		//flase����ͨ��
		System.out.println("interceptor1---preHandle");
		return true;
	}

	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
		
		
		// ��������֮��ִ���������
		System.out.println("interceptor1---postHandle");
	}

	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
			throws Exception {
		// �����������ִ���������
		System.out.println("interceptor1---afterHandle");
	}
	

	
	

}
