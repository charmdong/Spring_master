package com.donggun.springMaster.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * Board Controller
 * @author donggun.Chung
 * @since 2021.04.28.
 * @version 1.0 
 */
@RequestMapping("/board")
@Controller
public class BoardController {

	/**
	 * 전달된 아이디에 해당하는 사용자의 게시물 목록 조회
	 * @param id
	 * @param model
	 * @return list.jsp
	 */
	@RequestMapping(value="/list", method=RequestMethod.GET)
	public String getBoardList(@RequestParam("id") String id, Model model) {
		// List<BoardVO> boardList = boardService.getBoardList();
		// model.addAttribute("boardList", boardList);
		
		return "board/list";
	}
	
	/**
	 * 게시물 상세 조회 
	 * @param boardNo
	 * @param model
	 * @return detail.jsp
	 */
	@RequestMapping(value="/detail/{boardNo}", method=RequestMethod.GET)
	public String getDetailBoard(@PathVariable String boardNo, Model model) {
		// BoardVO board = boardService.getDetailBoard(boardNo);
		// model.addAttribute("board", board);
		
		return "board/detail";
	}
	
}
