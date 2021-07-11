package com.donggun.springMaster.controller.RestController;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.donggun.springMaster.model.ApiResult;
import com.donggun.springMaster.service.UserService;
import com.donggun.springMaster.vo.UserVO;

import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;

/**
 * 사용자 관련 API
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
	
	/**
	 * 사용자 정보 조회
	 * @param userId
	 * @return ApiResult<>
	 */
	@RequestMapping(value="/getUserInfo", method=RequestMethod.GET)
	@ApiOperation(value="사용자 정보 조회", notes="ID를 통해 사용자 정보를 조회한다.")
	@ApiImplicitParam(name="userId", value="사용자 아이디", required=true)
	public ApiResult<UserVO> getUserInfo(@RequestParam String userId) {
		ApiResult<UserVO> userInfo = null;
		
		try {
			userInfo = ApiResult.succeed(userService.getUserInfo(userId).get());
		} catch (Exception e) {
			userInfo = ApiResult.failed("사용자 정보를 조회하지 못했습니다.");
			e.printStackTrace();
		}
		
		return userInfo;
	}
	
	/**
	 * 사용자 정보 등록 및 수정
	 * @param userInfo
	 */
	@RequestMapping(value="/saveUserInfo", method=RequestMethod.POST)
	@ApiOperation(value="사용자 정보 등록 및 수정", notes="등록되어 있지 않으면 등록하고, 되어 있으면 수정한다.")
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
	@ApiOperation(value="사용자 정보 삭제", notes="ID에 해당하는 사용자 정보를 삭제한다.")
	@ApiImplicitParam(name="userId", value="사용자 아이디", required=true)
	public void deleteUserInfo(@RequestParam String userId) {
		try {
			userService.deleteUserInfo(userId);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
