package com.donggun.springMaster.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.donggun.springMaster.vo.CommentVO;

/**
 * Comment DAO
 * @author donggun.Chung
 * @since 2021.05.27.
 * @version 1.0 
 */
@Repository
public class CommentDAO {

	/**
	 * 댓글 목록 조회
	 * @param boardNo
	 * @return
	 */
	public List<CommentVO> getCommentList(String boardNo) {
		return null;
	}
	
	/**
	 * 댓글 상세 조회
	 * @param commentNo
	 * @return
	 */
	public CommentVO getCommentDetail(String commentNo) {
		return null;
	}
	
	/**
	 * 댓글 등록
	 * @param boardNo
	 * @param comment
	 */
	public void registComment(String boardNo, CommentVO comment) {
		;
	}
	
	/**
	 * 댓글 수정
	 * @param commentNo
	 * @param comment
	 */
	public void modifyComment(String commentNo, CommentVO comment) {
		;
	}
	
	/**
	 * 댓글 삭제
	 * @param boardNo
	 * @param commentNo
	 */
	public void deleteComment(String boardNo, String commentNo) {
		;
	}
}
