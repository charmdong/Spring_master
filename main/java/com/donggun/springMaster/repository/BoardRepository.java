package com.donggun.springMaster.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.donggun.springMaster.vo.BoardVO;
import com.donggun.springMaster.vo.UserVO;

public interface BoardRepository extends JpaRepository<BoardVO, String> {
	List<BoardVO> findByUser(UserVO user);
}
