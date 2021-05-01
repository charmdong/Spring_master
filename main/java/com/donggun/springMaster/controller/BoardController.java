package com.donggun.springMaster.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.donggun.springMaster.vo.BoardVO;

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
		// List<CommentVO> commentList = commentService.getCommentList(boardNo);
		// model.addAttribute("commentList", commentList);
		
		return "board/detail";
	}
	
	/**
	 * 게시물 삭제
	 * @param boardNo
	 * @return list.jsp
	 */
	@RequestMapping(value="/delete", method=RequestMethod.DELETE)
	public String deleteBoard(@RequestParam String boardNo) {
		// boardService.deleteBoard(boardNo);
		
		return "redirect:/list";
	}
	
	/**
	 * 수정 폼 이동
	 * @param board
	 * @return modifyForm.jsp
	 */
	@RequestMapping(value="/modifyForm", method=RequestMethod.POST)
	public String modifyForm(@ModelAttribute("board") BoardVO board) {
		return "board/modifyForm";
	}
	
	/**
	 * 게시물 수정
	 * @param board
	 * @return list.jsp
	 */
	@RequestMapping(value="/modify", method=RequestMethod.PUT)
	public String modifyBoard(@RequestBody BoardVO board) {
		// boardService.modifyBoard(board);
		
		return "redirect:/list";
	}
}
