package com.donggun.springMaster.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.donggun.springMaster.vo.UserVO;

public interface UserRepository extends JpaRepository<UserVO, String> {
	List<UserVO> findByUserName(String userName);
}
