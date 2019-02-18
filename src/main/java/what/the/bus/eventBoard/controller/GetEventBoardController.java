package what.the.bus.eventBoard.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import what.the.bus.eventBoard.EventBoardVO;
import what.the.bus.eventBoard.service.GetEventBoardService;

@Controller
public class GetEventBoardController {
	@Autowired
	private GetEventBoardService eventboardService;
	
	@RequestMapping("/view/**/getEventBoard.do")
	public String getEventBoard(Integer seq, String id, @RequestParam(defaultValue ="1") int curPage,
			@RequestParam(defaultValue = "") String keyword, @RequestParam(defaultValue = "all") String searchOption, Model model) {
		EventBoardVO vo = eventboardService.getEventBoard(seq);
		
		model.addAttribute("searchOption", searchOption);
		model.addAttribute("keyword", keyword);
		model.addAttribute("curPage", curPage);
		model.addAttribute("vo", vo);
		
		return "eventBoard/content";
	}
}
