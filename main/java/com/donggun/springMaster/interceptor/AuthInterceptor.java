package com.donggun.springMaster.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import com.donggun.springMaster.vo.LoginVO;

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
		LoginVO loginInfo = (LoginVO) session.getAttribute("loginInfo");
		System.out.println(loginInfo);
		if(!loginInfo.getIsAdmin()) {
			String userId = request.getParameter("userId");
			if(!loginInfo.getId().equals(userId)) {
				return false;
			}
		}
		
		return true;
	}
	
}
