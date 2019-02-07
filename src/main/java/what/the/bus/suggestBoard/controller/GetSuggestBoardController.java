package what.the.bus.suggestBoard.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import what.the.bus.suggestBoard.SuggestBoardVO;
import what.the.bus.suggestBoard.service.GetSuggestBoardService;

@Controller
public class GetSuggestBoardController {

	@Autowired
	private GetSuggestBoardService suggestBoardService;

	@RequestMapping("/view/**/getSuggestBoard.do")
	public String getSuggestBoard(Integer seq, Model model) {
		SuggestBoardVO vo = suggestBoardService.getSuggestBoard(seq);
		model.addAttribute("vo", vo);
		return "suggestBoard/content";
	}
	


}
