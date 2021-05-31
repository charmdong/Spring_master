package com.donggun.springMaster.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.donggun.springMaster.vo.BoardVO;

/**
 * Board DAO
 * @author donggun.Chung
 * @since 2021.05.27.
 * @version 1.0
 */
@Repository
public class BoardDAO {

	/**
	 * 게시글 조회
	 * @param boardNo
	 * @return board
	 */
	public BoardVO getBoard(String boardNo) {
		return null;
	}
	
	/**
	 * 사용자 작성 게시글 목록 조회
	 * @param id
	 * @return
	 */
	public List<BoardVO> getBoardList(String id) {
		return null;
	}
	
	/**
	 * 게시글 등록
	 * @param board
	 */
	public void reigstBoard(BoardVO board) {
		;
	}
	
	/**
	 * 게시글 수정
	 * @param boardNo
	 * @param board
	 */
	public void modifyBoard(BoardVO board) {
		;
	}
	
	/**
	 * 게시글 삭제
	 * @param boardNo
	 */
	public void deleteBoard(String boardNo) {
		;
	}
}
