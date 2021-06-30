package com.donggun.springMaster.controller.RestController;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.donggun.springMaster.service.UserService;
import com.donggun.springMaster.vo.UserVO;

/**
 * @author donggun.Chung
 * @since 2021.06.30.
 * @version 
 */
@RequestMapping("/userApi")
@RestController
public class UserRestController {
	
	private final UserService userService;
	
	@Autowired
	public UserRestController(UserService userService) {
		super();
		this.userService = userService;
	}
	
	@RequestMapping(value="/getUserInfo")
	public UserVO getUserInfo(@RequestParam String userId) {
		UserVO userInfo = null;
		
		try {
			userInfo = userService.getUserInfo(userId);
		} catch (Exception e) {

			e.printStackTrace();
		}
		
		return userInfo;
	}
	
	@RequestMapping("/getUserInfoList")
	public UserVO getUserInfoList() {
		return new UserVO();
	}
	
	@RequestMapping(value="/test")
	public String stringTest() {
		return "hello world";
	}
}
