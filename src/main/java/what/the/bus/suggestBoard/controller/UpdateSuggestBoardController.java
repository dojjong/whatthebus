package what.the.bus.suggestBoard.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import what.the.bus.suggestBoard.SuggestBoardVO;
import what.the.bus.suggestBoard.service.UpdateSuggestBoardService;

@Controller
public class UpdateSuggestBoardController {
	@Autowired
	private UpdateSuggestBoardService suggestBoardService;

	@RequestMapping("/view/**/updateSuggestForm.do")
	public String updateSuggestForm(int seq,SuggestBoardVO vo,Model model) {
		vo = suggestBoardService.getSuggestBoard(seq);
		model.addAttribute("vo", vo);
		return "suggestBoard/updateSuggestForm";
	}
}
	