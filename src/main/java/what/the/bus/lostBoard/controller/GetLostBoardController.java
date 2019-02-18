package what.the.bus.lostBoard.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import what.the.bus.lostBoard.LostBoardVO;
import what.the.bus.lostBoard.service.GetLostBoardService;

@Controller
public class GetLostBoardController {
	
	@Autowired
	private GetLostBoardService lostBoardService;
	
	@RequestMapping("/view/**/getLostBoard.do")
	public String getLostBoard(Integer seq, String id, @RequestParam(defaultValue ="1") int curPage,
			@RequestParam(defaultValue = "") String keyword, @RequestParam(defaultValue = "all") String searchOption, Model model) {
		LostBoardVO vo = lostBoardService.getLostBoard(seq);
		
		model.addAttribute("searchOption", searchOption);
		model.addAttribute("keyword", keyword);
		model.addAttribute("curPage", curPage);
		model.addAttribute("vo", vo);
		
		return "lostBoard/content";
	}
	
}
