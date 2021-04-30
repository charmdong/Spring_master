package com.donggun.springMaster.controller;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.donggun.springMaster.vo.UserVO;

/**
 * User Controller
 * @author donggun.Chung
 * @since 2021.04.28.
 * @version 1.0
 */
@RequestMapping("/user")
@Controller
public class UserController {
	
	/**
	 * 로그인 페이지로 이동
	 * @param 
	 * @return loginForm.jsp
	 */
	@RequestMapping(value="/loginForm", method=RequestMethod.GET)
	public String loginForm() {
		return "loginForm";
	}
	
	/**
	 * 로그인
	 * @param user
	 * @return main.jsp
	 */
	@RequestMapping(value="/login", method=RequestMethod.POST)
	public String login(@RequestBody UserVO user) {
		// TOOD login BL
		
		return "main";
	}
	
	/**
	 * 로그아웃
	 * @param session
	 * @return index.jsp 
	 */
	@RequestMapping(value="/logout", method=RequestMethod.GET) 
	public String logout(HttpSession session) {
		session.invalidate();
		
		return "index";
	}
	
}