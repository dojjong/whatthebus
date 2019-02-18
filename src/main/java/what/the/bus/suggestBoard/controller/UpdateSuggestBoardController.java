package what.the.bus.suggestBoard.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import what.the.bus.board.BoardVO;
import what.the.bus.suggestBoard.SuggestBoardVO;
import what.the.bus.suggestBoard.service.UpdateSuggestBoardService;

@Controller
public class UpdateSuggestBoardController {
	@Autowired
	private UpdateSuggestBoardService suggestBoardService;

	@RequestMapping("/view/**/updateSuggestForm.do")
	public String updateSuggestForm(int seq,BoardVO vo,Model model) {
		
		vo = suggestBoardService.getSuggestBoard(seq);
		model.addAttribute("vo", vo);
		return "suggestBoard/updateSuggestForm";
	}
	
	@RequestMapping("/view/**/updateSuggestBoard.do")
	public String updateBoard(@ModelAttribute BoardVO vo,int seq) {
		vo.setSeq(seq);
		
		suggestBoardService.updateSuggestBoard(vo);
		return "redirect:getSuggestBoardList.do";
	}
}
	