package com.donggun.springMaster.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

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
	
	@PersistenceContext
	EntityManager em;
	
	/**
	 * 사용자 정보 조회
	 * @param id
	 * @return
	 * @throws Exception
	 */
	public UserVO getUserInfo(String id) throws Exception {
		return em.find(UserVO.class, id);
	}
	
	/**
	 * 모든 사용자 정보 목록 조회
	 * @return
	 * @throws Exception
	 */
	public List<UserVO> getAllUserList() throws Exception {
		return em.createQuery("select u from USER u", UserVO.class).getResultList();
	}
	
	/**
	 * 사용자 정보 등록
	 * @param userInfo
	 * @throws Exception
	 */
	public void registUserInfo(UserVO userInfo) throws Exception {
		em.persist(userInfo);
	}
	
	/**
	 * 사용자 정보 수정
	 * @param id
	 * @param userInfo
	 * @throws Exception
	 */
	public void modifyUserInfo(UserVO userInfo) throws Exception {
		UserVO user = em.find(UserVO.class, userInfo.getId());
		
		// TODO user 정보 수정
	}

	/**
	 * 사용자 정보 삭제
	 * @param id
	 * @throws Exception
	 */
	public void deleteUserInfo(String id) throws Exception {
		UserVO user = em.find(UserVO.class, id);
		
		em.remove(user);
	}
}
