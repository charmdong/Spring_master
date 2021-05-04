package com.donggun.springMaster.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

/**
 * 권한 여부 확인 인터셉터
 * @author donggun.Chung
 * @since 2021.05.04.
 * @version 1.0 
 */
public class AuthInterceptor extends HandlerInterceptorAdapter {

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		HttpSession session = request.getSession();
		
		if(session == null) {
			response.sendRedirect("/index");
			return false;
		}
		
		if(session.getAttribute("isLogin") == null) {
			response.sendRedirect("/index");
			return false;
		}
		
		return true;
	}

	
}
