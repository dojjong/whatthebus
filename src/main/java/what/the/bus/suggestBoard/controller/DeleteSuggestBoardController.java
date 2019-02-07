package what.the.bus.suggestBoard.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import what.the.bus.suggestBoard.SuggestBoardVO;
import what.the.bus.suggestBoard.service.DeleteSuggestBoardService;

@Controller
public class DeleteSuggestBoardController {
	@Autowired
	private DeleteSuggestBoardService suggestBoardService;

	@RequestMapping("/view/**/deleteSuggestBoard.do")
	public String updateBoard(@ModelAttribute SuggestBoardVO vo, int seq) {
		vo.setSeq(seq);
		suggestBoardService.deleteSuggestBoard(vo);
		return "redirect:getSuggestBoardList.do";
	}

}
