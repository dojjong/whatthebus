package what.the.bus.bookBoard.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import what.the.bus.bookBoard.service.InsertBookBoardService;
import what.the.bus.suggestBoard.SuggestBoardVO;

@Controller
public class InsertBookBoardController {
	@Autowired
	private InsertBookBoardService bookBoardService;
	//게시판 글쓰기
	@RequestMapping("/view/**/writeBookBoard.do")
	public String writeBookBoard() {
		
		return "bookBoard/writeBookForm";
	}
	
	@RequestMapping("/view/**/insertBookBoard.do")
	public String insertBookBoard(SuggestBoardVO vo) {
		bookBoardService.insertBookBoard(vo);
		return "redirect:getBookBoardList.do";
	}
}