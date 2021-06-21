package com.donggun.springMaster.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.donggun.springMaster.service.BoardService;
import com.donggun.springMaster.vo.BoardVO;
import com.donggun.springMaster.vo.CommentVO;

/**
 * Board Controller
 * @author donggun.Chung
 * @since 2021.04.28.
 * @version 1.0 
 */
@RequestMapping("/board")
@Controller
public class BoardController {
	
	private final BoardService boardService;
	
	@Autowired
	public BoardController(BoardService boardService) {
		super();
		this.boardService = boardService;
	}


	/**
	 * 전달된 아이디에 해당하는 사용자의 게시물 목록 조회
	 * @param id
	 * @param model
	 * @return list.jsp
	 */
	@RequestMapping(value="/list", method=RequestMethod.GET)
	public String getBoardList(@RequestParam(value="id", required=true) String id, Model model) {
		List<BoardVO> boardList = null;
		
		try {
			boardList = boardService.getBoardList(id);
		} catch (Exception e) {
			e.printStackTrace();
		}

		model.addAttribute("boardList", boardList);
		
		return "board/list";
	}

	/**
	 * 게시물 상세 조회 
	 * @param boardNo
	 * @param model
	 * @return detail.jsp
	 */
	@RequestMapping(value="/detail/{boardNo}", method=RequestMethod.GET)
	public String getDetailBoardInfo(@PathVariable String boardNo, Model model) {
		BoardVO board = null;
		
		try {
			board = boardService.getBoardInfo(boardNo);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		List<CommentVO> commentList = board.getCommentList();
		model.addAttribute("board", board);
		model.addAttribute("commentList", commentList);
		
		return "board/detail";
	}
	
	/**
	 * 게시물 삭제
	 * @param boardNo
	 * @return list.jsp
	 */
	@RequestMapping(value="/delete", method=RequestMethod.DELETE)
	public String deleteBoard(@RequestParam(value="boardNo", required=true) String boardNo) {
		try {
			boardService.deleteBoard(boardNo);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
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
		try {
			boardService.saveBoard(board);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return "redirect:/list";
	}
}
