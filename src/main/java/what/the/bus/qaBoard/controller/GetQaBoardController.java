package what.the.bus.qaBoard.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import what.the.bus.qaBoard.QaBoardVO;
import what.the.bus.qaBoard.service.GetQaBoardService;

@Controller
public class GetQaBoardController {
	
	@Autowired
	private GetQaBoardService qaBoardService;
	
	@RequestMapping("/view/**/getQaBoard.do")
	public String getQaBoard(Integer seq, String id, @RequestParam(defaultValue ="1") int curPage,
			@RequestParam(defaultValue = "") String keyword, @RequestParam(defaultValue = "all") String searchOption, Model model) {
		QaBoardVO vo = qaBoardService.getQaBoard(seq);
		
		model.addAttribute("searchOption", searchOption);
		model.addAttribute("keyword", keyword);
		model.addAttribute("curPage", curPage);
		model.addAttribute("vo", vo);
		
		return "qaBoard/content";
	}
	
}
