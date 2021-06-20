package com.donggun.springMaster.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.donggun.springMaster.dao.UserDAO;
import com.donggun.springMaster.service.UserService;
import com.donggun.springMaster.vo.UserVO;

/**
 * User Service Implement
 * @author donggun.Chung
 * @since 2021.04.28.
 * @version 1.0
 */
@Service
public class UserServiceImpl implements UserService {

	private final UserDAO userDao;
	
	@Autowired
	public UserServiceImpl(UserDAO userDao) {
		super();
		this.userDao = userDao;
	}
	
	@Override
	public UserVO getUserInfo(String userId) throws Exception {
		return userDao.getUserInfo(userId);
	}

	@Override
	public UserVO login(UserVO user) throws Exception {
		UserVO userInfo = userDao.getUserInfo(user.getId());
		return userInfo;
	}

	@Override
	public void registUserInfo(UserVO user) throws Exception {
		userDao.registUserInfo(user);
	}

	@Override
	public void modifyUserInfo(UserVO user) throws Exception {
		userDao.modifyUserInfo(user);
	}

	@Override
	public void deleteUserInfo(String userId) throws Exception {
		userDao.deleteUserInfo(userId);
	}
	
}
