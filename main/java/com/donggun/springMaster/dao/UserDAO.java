package com.donggun.springMaster.dao;

import org.springframework.stereotype.Repository;

import com.donggun.springMaster.vo.UserVO;

/**
 * User DAO
 * @author donggun.Chung
 * @since 2021.05.26.
 * @version 1.0 
 */
@Repository
public class UserDAO {
	
	/**
	 * 사용자 정보 조회
	 * @param id
	 * @return
	 * @throws Exception
	 */
	public UserVO getUserInfo(String id) throws Exception {
		return null;
	}
	
	/**
	 * 사용자 정보 등록
	 * @param userInfo
	 * @throws Exception
	 */
	public void registUserInfo(UserVO userInfo) throws Exception {
		;
	}
	
	/**
	 * 사용자 정보 수정
	 * @param id
	 * @param userInfo
	 * @throws Exception
	 */
	public void modifyUserInfo(UserVO userInfo) throws Exception {
		;
	}

	/**
	 * 사용자 정보 삭제
	 * @param id
	 * @throws Exception
	 */
	public void deleteUserInfo(String id) throws Exception {
		;
	}
}
