package what.the.bus.lostBoard.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import what.the.bus.lostBoard.LostBoardVO;
import what.the.bus.lostBoard.service.GetLostBoardService;

@Controller
public class GetLostBoardController {

	@Autowired
	private GetLostBoardService lostBoardService;
	
	@RequestMapping("view/**/getLostBoard.do")
	public String getLostBoard(Integer seq, Model model) {
		LostBoardVO vo = lostBoardService.getLostBoard(seq);
		model.addAttribute("vo", vo);
		
		return "lostBoard/content";
	}
}
