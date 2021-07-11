package com.donggun.springMaster.controller;

import java.util.Date;
import java.util.Optional;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.donggun.springMaster.service.UserService;
import com.donggun.springMaster.vo.LoginVO;
import com.donggun.springMaster.vo.RoleType;
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
	@RequestMapping(value="/login", method=RequestMethod.POST)
	public String login(@RequestParam String userId, @RequestParam String password, HttpSession session, Model model) {
		Optional<UserVO> userInfo = null;
		
		try {
			userInfo = userService.login(userId, password);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		if(userInfo == null) {
			model.addAttribute("resultCode", "FAIL");
			model.addAttribute("errorMsg", "로그인에 실패했습니다. 아이디와 패스워드를 확인해주세요.");
			return "user/loginForm";
		}
		
		LoginVO loginVO = new LoginVO();
		
		loginVO.setId(userInfo.get().getId());
		loginVO.setName(userInfo.get().getUserName());
		loginVO.setLoginDate(new Date());
		loginVO.setIsAdmin(RoleType.ADMIN.equals(userInfo.get().getRoleType()));
		
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
		
		return "redirect:/";
	}
	
	/**
	 * 사용자 정보 등록 및 수정
	 * @param user
	 * @return
	 */
	@RequestMapping(value="/save", method=RequestMethod.POST)
	public String saveUserInfo(UserVO user) {
		
		try {
			userService.saveUserInfo(user);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return "/main";
	}
	
	/**
	 * 사용자 정보 삭제
	 * @param userId
	 * @return
	 */
	@RequestMapping(value="/delete", method=RequestMethod.DELETE)
	public String deleteUserInfo(@RequestParam String userId) {
		try {
			userService.deleteUserInfo(userId);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return "redirect:/";
	}
}