package what.the.bus.bookBoard.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import what.the.bus.bookBoard.BookBoardVO;
import what.the.bus.bookBoard.service.DeleteBookBoardService;

@Controller
public class DeleteBookBoardController {
	@Autowired
	private DeleteBookBoardService bookBoardService;

	@RequestMapping("/view/**/deleteBookBoard.do")
	public String updateBookBoard(@ModelAttribute BookBoardVO vo, int seq) {
		vo.setSeq(seq);
		bookBoardService.deleteBookBoard(vo);
		return "redirect:getBookBoardList.do";
	}

}
