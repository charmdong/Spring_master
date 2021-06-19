package com.donggun.springMaster.service;

import com.donggun.springMaster.vo.UserVO;

/**
 * UserService Interface
 * @author donggun.Chung
 * @since 2021.04.28.
 * @version 1.0
 */
public interface UserService {
	
	public UserVO login(UserVO user) throws Exception;
	
	public UserVO getUserInfo(String userId) throws Exception;
	
	public void registUserInfo(UserVO user) throws Exception;
	
	public void changeUserInfo(UserVO user) throws Exception;
	
	public void deleteUserInfo(UserVO user) throws Exception;
}
