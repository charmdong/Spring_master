package com.donggun.springMaster.service;

import java.util.List;
import java.util.Optional;

import com.donggun.springMaster.vo.BoardVO;
import com.donggun.springMaster.vo.CommentVO;

/**
 * Board Service Interface
 * @author donggun.Chung
 * @since 2021.05.02.
 * @version 1.0
 */
public interface BoardService {

	public Optional<BoardVO> getBoardInfo(String userId, String boardNo) throws Exception;
	
	public List<BoardVO> getBoardList(String regId) throws Exception;
	
	public void saveBoard(BoardVO board) throws Exception;
	
	public void deleteBoard(String boardNo) throws Exception;
	
	public Optional<CommentVO> getCommentInfo(String boardNo, String commentNo) throws Exception;
	
	public void saveComment(CommentVO comment) throws Exception;
	
	public void deleteComment(String boardNo, String commentNo) throws Exception;
}
