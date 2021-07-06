package com.donggun.springMaster.controller.RestController;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.donggun.springMaster.service.UserService;
import com.donggun.springMaster.vo.UserVO;

import io.swagger.annotations.Api;

/**
 * 사용자 관련 API
 * @author donggun.Chung
 * @since 2021.06.30.
 * @version 
 */
@RequestMapping("/userApi")
@RestController
@Api(value="UserRestController", description="UserRestController Test.")
public class UserRestController {
	
	private final UserService userService;
	
	@Autowired
	public UserRestController(UserService userService) {
		super();
		this.userService = userService;
	}
	
	/**
	 * 사용자 정보 조회
	 * @param userId
	 * @return
	 */
	@RequestMapping(value="/getUserInfo", method=RequestMethod.GET)
	public UserVO getUserInfo(@RequestParam String userId) {
		UserVO userInfo = null;
		
		try {
			userInfo = userService.getUserInfo(userId);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return userInfo;
	}
	
	/**
	 * 사용자 정보 등록 및 수정
	 * @param userInfo
	 */
	@RequestMapping(value="/saveUserInfo", method=RequestMethod.POST)
	public void saveUserInfo(UserVO userInfo) {
		try {
			userService.saveUserInfo(userInfo);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * 사용자 정보 삭제
	 * @param userId
	 */
	@RequestMapping(value="/deleteUserInfo", method=RequestMethod.DELETE)
	public void deleteUserInfo(@RequestParam String userId) {
		try {
			userService.deleteUserInfo(userId);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
