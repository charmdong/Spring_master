package com.donggun.springMaster.controller;

import java.util.Date;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.donggun.springMaster.service.UserService;
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
	
	private final UserService userService;
	
	@Autowired
	public UserController(UserService userService) {
		super();
		this.userService = userService;
	}

	/**
	 * 로그인
	 * @param user
	 * @return main.jsp
	 */
	@SuppressWarnings("unlikely-arg-type")
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
		loginVO.setIsAdmin(userInfo.getRoleType().equals(0));
		
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
	
	/**
	 * 사용자 상세 정보 조회
	 * @param userId
	 * @param model
	 * @return detail.jsp
	 */
	@RequestMapping(value="/detail", method=RequestMethod.GET)
	public String userDetail(@RequestParam String userId, Model model) {
		UserVO userInfo = null;
		
		try {
			userInfo = userService.getUserInfo(userId);
		} catch (Exception e) {
			e.printStackTrace();
		}
		model.addAttribute("userInfo", userInfo);
		
		return "detail";
	}
	
	/**
	 * 사용자 정보 등록
	 * @param user
	 * @return
	 */
	@RequestMapping(value="/regist", method=RequestMethod.POST)
	public String registUserInfo(@RequestBody UserVO user) {
		try {
			userService.registUserInfo(user);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return "redirect:/index";
	}
	
	/**
	 * 사용자 정보 수정
	 * @param user
	 * @return
	 */
	@RequestMapping(value="/modify", method=RequestMethod.PUT)
	public String modifyUserInfo(@RequestBody UserVO user) {
		try {
			userService.modifyUserInfo(user);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return "detail";
	}
	
	@RequestMapping(value="/delete", method=RequestMethod.DELETE)
	public String deleteUserInfo(@RequestParam String userId) {
		try {
			userService.deleteUserInfo(userId);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return "redirect:/index";
	}
}