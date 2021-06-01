package com.donggun.springMaster.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

import com.donggun.springMaster.vo.CommentVO;

/**
 * Comment DAO
 * 
 * @author donggun.Chung
 * @since 2021.05.27.
 * @version 1.0
 */
@Repository
public class CommentDAO {

	@PersistenceContext
	EntityManager em;

	/**
	 * 댓글 목록 조회
	 * 
	 * @param boardNo
	 * @return
	 */
	public List<CommentVO> getCommentList(String boardNo) {
		return em.createQuery("select c from COMMENT c where boardNo = :boardNo", CommentVO.class)
				.setParameter("boardNo", boardNo).getResultList();
	}

	/**
	 * 댓글 상세 조회
	 * 
	 * @param commentNo
	 * @return
	 */
	public CommentVO getCommentDetail(String commentNo) {
		return em.find(CommentVO.class, commentNo);
	}

	/**
	 * 댓글 등록
	 * 
	 * @param boardNo
	 * @param comment
	 */
	public void registComment(String boardNo, CommentVO comment) {
		em.persist(comment);
	}

	/**
	 * 댓글 수정
	 * 
	 * @param commentNo
	 * @param comment
	 */
	public void modifyComment(String commentNo, CommentVO comment) {
		;
	}

	/**
	 * 댓글 삭제
	 * 
	 * @param boardNo
	 * @param commentNo
	 */
	public void deleteComment(String boardNo, String commentNo) {
		;
	}
}
