package com.donggun.springMaster.service.impl;

import java.util.List;
import java.util.Optional;
import java.util.stream.Stream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.donggun.springMaster.repository.BoardRepository;
import com.donggun.springMaster.repository.UserRepository;
import com.donggun.springMaster.service.BoardService;
import com.donggun.springMaster.vo.BoardVO;
import com.donggun.springMaster.vo.CommentVO;
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
	@Transactional
	public Optional<BoardVO> getBoardInfo(String userId, String boardNo) throws Exception {
		// TODO JPQL
		return Optional.ofNullable(boardRepository.findOne(boardNo));
	}

	/**
	 * 게시글 목록 조회
	 * 
	 * @param regId
	 * @return 게시글 목록
	 * @throws Exception
	 */
	@Override
	@Transactional
	public List<BoardVO> getBoardList(String regId) throws Exception {
		UserVO user = userRepository.findOne(regId);
		
		List<BoardVO> boardList = boardRepository.findByUser(user);
		
		Stream<BoardVO> stream = boardList.stream();
		
		stream.forEach(board -> System.out.println(board));
		
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

	/**
	 * 게시글 댓글 조회
	 * 
	 * @param boardNo
	 * @param commentNo
	 * @return comment Info
	 * @throws Exception
	 */
	@Override
	@Transactional
	public Optional<CommentVO> getCommentInfo(String boardNo, String commentNo) throws Exception {
		Optional<BoardVO> board = Optional.ofNullable(boardRepository.findOne(boardNo));
		Optional<CommentVO> comment = board.get().getCommentList().stream().filter(c -> commentNo.equals(c.getCommentNo())).findFirst();
		
		return comment;
	}

	/**
	 * 댓글 등록 및 수정
	 * 
	 * @param comment
	 * @throws Exception
	 */
	@Override
	public void saveComment(CommentVO comment) throws Exception {
		
	}

	/**
	 * 댓글 삭제
	 * 
	 * @param boardNo
	 * @param commentNo
	 * @throws Exception
	 */
	@Override
	public void deleteComment(String boardNo, String commentNo) throws Exception {
		
	}
	
}
