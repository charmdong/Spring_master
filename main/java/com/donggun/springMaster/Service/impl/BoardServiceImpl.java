package com.donggun.springMaster.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.donggun.springMaster.dao.BoardDAO;
import com.donggun.springMaster.service.BoardService;
import com.donggun.springMaster.vo.BoardVO;

/**
 * Board 서비스 구현 객체
 * 
 * @author donggun.Chung
 * @since 2021.05.02.
 * @version 1.0
 */

@Service
public class BoardServiceImpl implements BoardService {

	private final BoardDAO boardDao;

	@Autowired
	public BoardServiceImpl(BoardDAO boardDao) {
		super();
		this.boardDao = boardDao;
	}

	/**
	 * 게시글 조회
	 * 
	 * @param boardNo
	 * @return boardInfo
	 * @throws Exception
	 */
	@Override
	public BoardVO getBoardInfo(String boardNo) throws Exception {
		return boardDao.getBoard(boardNo);
	}

	/**
	 * 게시글 목록 조회
	 * 
	 * @param regId
	 * @return 게시글 목록
	 * @throws Exception
	 */
	@Override
	public List<BoardVO> getBoardList(String regId) throws Exception {
		List<BoardVO> boardList = boardDao.getBoardList(regId);
		
		return boardList;
	}

	/**
	 * 게시글 등록
	 * 
	 * @param board
	 * @throws Exception
	 */
	@Override
	public void registBoard(BoardVO board) throws Exception {
		boardDao.reigstBoard(board);
	}

	/**
	 * 게시글 수정
	 * 
	 * @param board
	 * @throws Exception
	 */
	@Override
	public void modifyBoard(BoardVO board) throws Exception {
		boardDao.modifyBoard(board);
	}

	/**
	 * 게시글 삭제
	 * 
	 * @param boardNo
	 * @throws Exception
	 */
	@Override
	public void deleteBoard(String boardNo) throws Exception {
		boardDao.deleteBoard(boardNo);
	}
	
}
