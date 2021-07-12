package com.donggun.springMaster.controller.RestController;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.donggun.springMaster.model.ApiResult;
import com.donggun.springMaster.service.BoardService;
import com.donggun.springMaster.vo.BoardVO;
import com.donggun.springMaster.vo.CommentVO;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

/**
 * @author donggun.Chung
 * @since 2021.07.03.
 * @version 
 */
@RequestMapping("/api/board")
@RestController
@Api(value = "게시글 관련 API")
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
	@ApiOperation(value="게시글 목록 조회", notes="사용자가 작성한 게시글 목록을 조회한다.")
	@ApiImplicitParam(name="userId", value="사용자 아이디", required=true, dataType="String")
	@ApiResponses({
		@ApiResponse(code = 200, message = "[SUCCESS] 게시글 목록을 조회했습니다."),
		@ApiResponse(code = 404, message = "[ERROR] 서버에 문제가 발생했습니다."),
		@ApiResponse(code = 500, message = "[ERROR] 페이지를 찾을 수 없습니다.")
	})
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
	@ApiOperation(value="게시글 상제 정보 조회", notes="게시글 상세 정보를 조회한다.")
	@ApiImplicitParam(name="boardNo", value="게시글 번호", required=true)
	public ApiResult<BoardVO> getBoardInfo(@PathVariable String boardNo) {
		ApiResult<BoardVO> board = null;
		
		try {
			board = ApiResult.succeed(boardService.getBoardInfo(boardNo).get());
		} catch (Exception e) {
			board = ApiResult.failed("게시글 정보를 조회하지 못했습니다.");
			e.printStackTrace();
		}
		
		return board;
	}
	
/*
 	@RequestMapping(value="/detail/{boardNo}/comment/{commentNo}", method=RequestMethod.GET)
	@ApiOperation(value="댓글 정보 조회", notes="게시글에 달린 댓글을 상세 조회한다.")
	@ApiImplicitParams({
		@ApiImplicitParam(name="boardNo", value="게시글 번호", required=true),
		@ApiImplicitParam(name="commentNo", value="댓글 번호", required=true)
	})
	public ApiResult<CommentVO> getCommentInfo(@PathVariable String boardNo, @PathVariable String commentNo) {
		ApiResult<CommentVO> comment = null;
		
		try {
			
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		return comment;
	}
*/	
	
	/**
	 * 게시글 삭제
	 * @param boardNo
	 */
	@RequestMapping(value="/delete", method=RequestMethod.DELETE)
	@ApiOperation(value="게시글 삭제", notes="게시글을 삭제한다.")
	@ApiImplicitParam(name="boardNo", value="게시글 번호", required=true)
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
	@ApiOperation(value="게시글 등록 및 수정", notes="게시글이 존재하면 수정하고, 그렇지 않으면 새로 등록한다.")
	@ApiImplicitParams({
		@ApiImplicitParam(name="boardNo", value="게시글 번호", required = true, dataType = "String"),
		@ApiImplicitParam(name="user", value="작성자 정보", required = true, dataType="UserVO"),
		@ApiImplicitParam(name="content", value="게시글 내용", required=false, dataType="String"),
		@ApiImplicitParam(name="likeCnt", value="좋아요 수", required=false, dataType="int", defaultValue="0"),
		@ApiImplicitParam(name="regDate", value="등록 날짜", required=false, dataType="Date"),
		@ApiImplicitParam(name="modDate", value="수정 날짜", required=false, dataType="Date")
	})
	public void saveBoardInfo(BoardVO board) {
		try {
			boardService.saveBoard(board);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
