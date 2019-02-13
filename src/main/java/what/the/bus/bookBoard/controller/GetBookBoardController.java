package what.the.bus.bookBoard.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import what.the.bus.bookBoard.service.GetBookBoardService;
import what.the.bus.suggestBoard.SuggestBoardVO;

@Controller
public class GetBookBoardController {

	@Autowired
	private GetBookBoardService bookBoardService;

	@RequestMapping("/view/**/getBookBoard.do")
	public String getBookBoard(Integer seq, Model model) {
		SuggestBoardVO vo = bookBoardService.getBookBoard(seq);
		model.addAttribute("vo", vo);
		System.out.println("mid_wido="+vo.getMid_wido());
		return "bookBoard/content";
	}

}
