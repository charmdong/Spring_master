package com.donggun.springMaster.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.donggun.springMaster.repository.UserRepository;
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

	private final UserRepository userRepository;
	
	@Autowired
	public UserServiceImpl(UserRepository userRepository) {
		super();
		this.userRepository = userRepository;
	}

	@Override
	public Optional<UserVO> login(String userId, String password) throws Exception {
		
		Optional<UserVO> userInfo = Optional.ofNullable(userRepository.findOne(userId));
		
		if(!userInfo.isPresent()) {
			return null;
		}
		else {
			if(!password.equals(userInfo.get().getPassword())) {
				return null;
			}
			
			return userInfo;
		}
	}

	@Override
	@Transactional
	public Optional<UserVO> getUserInfo(String userId) throws Exception {
		return Optional.ofNullable(userRepository.findOne(userId));
	}
	
	@Override
	public List<UserVO> getUserListByName(String userName) throws Exception {
		return userRepository.findByUserName(userName);
	}

	@Override
	@Transactional
	public void saveUserInfo(UserVO userInfo) throws Exception {
		UserVO origin = userRepository.findOne(userInfo.getId());

		origin.setNickName(userInfo.getNickName());
		origin.setUserName(userInfo.getUserName());
		origin.setEmail(userInfo.getEmail());
		origin.setPhone(userInfo.getPhone());
		origin.setHomepage(userInfo.getHomepage());
		origin.setDescription(userInfo.getDescription());
		
		userRepository.save(origin);
	}

	@Override
	@Transactional
	public void deleteUserInfo(String userId) throws Exception {
		userRepository.delete(userId);
	}
	
}
