package what.the.bus.board.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import what.the.bus.board.BoardVO;
import what.the.bus.board.service.InsertBoardService;

@Controller
public class InsertBoardController {
	@Autowired
	private InsertBoardService boardService;

	// 게시판 글쓰기화면으로 이동
	@RequestMapping("/view/**/writeBoard.do")
	public String writeBoard() {
		return "board/writeForm";
	}

	// 디비에 게시글 등록
	@RequestMapping("/view/**/insertBoard.do")
	public String insertBoard(BoardVO vo) {
		boardService.insertBoard(vo);
		return "redirect:getBoardList.do";
	}

}