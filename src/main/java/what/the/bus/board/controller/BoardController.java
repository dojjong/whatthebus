package what.the.bus.board.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import what.the.bus.board.BoardVO;
import what.the.bus.board.service.InsertBoardService;

@Controller
public class BoardController {
	@Autowired
	private InsertBoardService boardService;
	//게시판 글쓰기
	@RequestMapping("/view/**/writeBoard.do")
	public String writeBoard() {
		
		return "redirect:writeForm.jsp";
	}
	
	@RequestMapping("/view/**/insertBoard.do")
	public String insertBoard(BoardVO vo) {
		boardService.insertBoard(vo);
		return "redirect:list.jsp";
	}
}
