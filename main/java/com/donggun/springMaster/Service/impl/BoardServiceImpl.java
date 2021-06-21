package com.donggun.springMaster.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.donggun.springMaster.repository.BoardRepository;
import com.donggun.springMaster.repository.UserRepository;
import com.donggun.springMaster.service.BoardService;
import com.donggun.springMaster.vo.BoardVO;
import com.donggun.springMaster.vo.UserVO;

/**
 * Board 서비스 구현 객체
 * 
 * @author donggun.Chung
 * @since 2021.05.02.
 * @version 1.0
 */

@Service
public class BoardServiceImpl implements BoardService {

	private final BoardRepository boardRepository;
	private final UserRepository userRepository;
	
	@Autowired
	public BoardServiceImpl(BoardRepository boardRepository, UserRepository userRepository) {
		super();
		this.boardRepository = boardRepository;
		this.userRepository = userRepository;
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
		return boardRepository.findOne(boardNo);
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
		UserVO user = userRepository.findOne(regId);
		
		List<BoardVO> boardList = boardRepository.findByUser(user);
		
		return boardList;
	}

	/**
	 * 게시글 등록 및 수정
	 * 
	 * @param board
	 * @throws Exception
	 */
	@Override
	public void saveBoard(BoardVO board) throws Exception {
		boardRepository.save(board);
	}


	/**
	 * 게시글 삭제
	 * 
	 * @param boardNo
	 * @throws Exception
	 */
	@Override
	public void deleteBoard(String boardNo) throws Exception {
		boardRepository.delete(boardNo);
	}
	
}
