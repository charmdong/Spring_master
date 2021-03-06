package com.donggun.springMaster.service;

import java.util.List;
import java.util.Optional;

import com.donggun.springMaster.vo.UserVO;

/**
 * UserService Interface
 * @author donggun.Chung
 * @since 2021.04.28.
 * @version 1.0
 */
public interface UserService {
	
	public Optional<UserVO> login(String userId, String password) throws Exception;
	
	public Optional<UserVO> getUserInfo(String userId) throws Exception;
	
	public List<UserVO> getUserListByName(String userName) throws Exception;
	
	public void saveUserInfo(UserVO userInfo) throws Exception;
	
	public void deleteUserInfo(String userId) throws Exception;
}
