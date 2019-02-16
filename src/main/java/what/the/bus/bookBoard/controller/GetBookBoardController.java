package what.the.bus.bookBoard.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import what.the.bus.best.BestVO;
import what.the.bus.bookBoard.service.GetBookBoardService;
import what.the.bus.suggestBoard.SuggestBoardVO;

@Controller
public class GetBookBoardController {

	@Autowired
	private GetBookBoardService bookBoardService;

	@RequestMapping("/view/**/getBookBoard.do")
	public String getBookBoard(Integer seq, String id, @RequestParam(defaultValue = "1") int curPage,
			@RequestParam(defaultValue = "") String keyword, @RequestParam(defaultValue = "all") String searchOption,
			Model model) {
		SuggestBoardVO vo = bookBoardService.getBookBoard(seq);
		model.addAttribute("searchOption", searchOption);
		model.addAttribute("keyword", keyword);
		model.addAttribute("curPage", curPage);
		model.addAttribute("vo", vo);
		return "bookBoard/content";
	}

}
