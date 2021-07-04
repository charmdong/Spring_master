package com.donggun.springMaster.controller.RestController;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.donggun.springMaster.service.BoardService;
import com.donggun.springMaster.vo.BoardVO;

/**
 * @author donggun.Chung
 * @since 2021.07.03.
 * @version 
 */
@RequestMapping("/boardApi")
@RestController
public class BoardRestController {
	
	private final BoardService boardService;
	
	@Autowired
	public BoardRestController(BoardService boardService) {
		super();
		this.boardService = boardService;
	}
	
	/**
	 * 사용자가 작성한 게시글 목록 조회
	 * @param regId
	 * @return
	 */
	@RequestMapping(value="/list", method=RequestMethod.GET)
	public List<BoardVO> getBoardList(@RequestParam("userId") String regId) {
		List<BoardVO> boardList = null;
		
		try {
			boardList = boardService.getBoardList(regId);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return boardList;
	}
	
	/**
	 * 게시물 상세 정보 조회
	 * @param boardNo
	 * @return
	 */
	@RequestMapping(value="/detail/{boardNo}", method=RequestMethod.GET) 
	public BoardVO getBoardInfo(@PathVariable String boardNo) {
		BoardVO boardInfo = null;
		
		try {
			boardInfo = boardService.getBoardInfo(boardNo);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return boardInfo;
	}
	
	/**
	 * 게시글 삭제
	 * @param boardNo
	 */
	@RequestMapping(value="/delete", method=RequestMethod.DELETE)
	public void deleteBoardInfo(@RequestParam String boardNo) {
		try {
			boardService.deleteBoard(boardNo);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	/**
	 * 게시글 등록 및 수정
	 * @param board
	 */
	@RequestMapping(value="/save", method=RequestMethod.POST) 
	public void saveBoardInfo(BoardVO board) {
		try {
			boardService.saveBoard(board);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
