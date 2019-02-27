package what.the.bus.bookBoard.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import what.the.bus.bookBoard.service.DeleteBookBoardService;
import what.the.bus.suggestBoard.SuggestBoardVO;

@Controller
public class DeleteBookBoardController {
	@Autowired
	private DeleteBookBoardService bookBoardService;

	@RequestMapping("/view/**/deleteBookBoard.do")
	public String updateBookBoard(@ModelAttribute SuggestBoardVO vo, int seq) {
		vo.setSeq(seq);
		vo.setBest(-1);
		bookBoardService.deleteBookBoard(vo);
		return "redirect:getBookBoardList.do";
	}

}
