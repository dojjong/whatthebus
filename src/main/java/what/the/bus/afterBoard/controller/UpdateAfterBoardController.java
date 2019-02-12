package what.the.bus.afterBoard.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import what.the.bus.afterBoard.AfterBoardVO;
import what.the.bus.afterBoard.service.UpdateAfterBoardService;

@Controller
public class UpdateAfterBoardController {

	@Autowired
	private UpdateAfterBoardService afterBoardService;

	@RequestMapping(value="/view/**/updateAfterForm.do", method=RequestMethod.GET)
	public String updateAfterForm(@RequestParam int seq, Model model) throws Exception {
		AfterBoardVO vo = afterBoardService.getAfterBoard(seq);
		model.addAttribute("vo", vo);
		return "afterBoard/updateAfterForm";
	}
	
	
	@RequestMapping(value="/view/**/updateAfterBoard.do", method=RequestMethod.POST)
	public String updateAfterBoard(@ModelAttribute AfterBoardVO vo) throws Exception {
		afterBoardService.updateAfterBoard(vo);
		return "redirect:getAfterBoardList.do";
	}
}
