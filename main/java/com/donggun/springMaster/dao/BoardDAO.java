package com.donggun.springMaster.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

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
	
	@PersistenceContext
	EntityManager em;

	/**
	 * 게시글 조회
	 * @param boardNo
	 * @return board
	 */
	public BoardVO getBoard(String boardNo) {
		return em.find(BoardVO.class, boardNo);
	}
	
	/**
	 * 사용자 작성 게시글 목록 조회
	 * @param id
	 * @return
	 */
	public List<BoardVO> getBoardList(String id) {
		return em.createQuery("select b from Board b where b.regId = :id", BoardVO.class).setParameter("id", id).getResultList();
	}
	
	/**
	 * 게시글 등록
	 * @param board
	 */
	public void reigstBoard(BoardVO board) {
		em.persist(board);
	}
	
	/**
	 * 게시글 수정
	 * @param boardNo
	 * @param board
	 */
	public void modifyBoard(BoardVO board) {
		BoardVO origin = em.find(BoardVO.class, board.getBoardNo());
		
		// TODO set info
	}
	
	/**
	 * 게시글 삭제
	 * @param boardNo
	 */
	public void deleteBoard(String boardNo) {
		BoardVO board = em.find(BoardVO.class, boardNo);
		em.remove(board);
	}
}
