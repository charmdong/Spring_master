package com.donggun.springMaster.controller;

import java.util.Date;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.donggun.springMaster.service.impl.UserServiceImpl;
import com.donggun.springMaster.vo.LoginVO;
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
	
	private final UserServiceImpl userService;
	
	@Autowired
	public UserController(UserServiceImpl userService) {
		super();
		this.userService = userService;
	}

	/**
	 * 로그인
	 * @param user
	 * @return main.jsp
	 */
	@RequestMapping(value="/login", method=RequestMethod.POST)
	public String login(@RequestBody UserVO user, HttpSession session) {
		UserVO userInfo = null;
		
		try {
			userInfo = userService.login(user);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		LoginVO loginVO = new LoginVO();
		
		loginVO.setId(userInfo.getId());
		loginVO.setName(userInfo.getUserName());
		loginVO.setLoginDate(new Date());
		// loginVO.setIsAdmin(userVO.getRoleType() == 0);
		
		session.setAttribute("loginInfo", loginVO);
		
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