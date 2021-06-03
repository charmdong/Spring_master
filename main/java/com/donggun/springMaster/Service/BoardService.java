package com.donggun.springMaster.service;

import java.util.List;

import com.donggun.springMaster.vo.BoardVO;

/**
 * Board Service Interface
 * @author donggun.Chung
 * @since 2021.05.02.
 * @version 1.0
 */
public interface BoardService {

	public BoardVO getDetailBoardInfo(String boardNo) throws Exception;
	
	public List<BoardVO> getBoardList(String regId) throws Exception;
	
	public void registBoard(BoardVO board) throws Exception;
	
	public void modifyBoard(BoardVO board) throws Exception;
	
	public void deleteBoard(String boardNo) throws Exception;
}
