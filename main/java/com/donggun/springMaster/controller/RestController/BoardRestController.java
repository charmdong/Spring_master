package com.donggun.springMaster.controller.RestController;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
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
}
