package what.the.bus.qaBoard.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import what.the.bus.qaBoard.QaBoardVO;
import what.the.bus.qaBoard.service.GetQaBoardService;

@Controller
public class GetQaBoardController {
	
	@Autowired
	private GetQaBoardService qaBoardService;
	
	@RequestMapping("view/**/getQaBoard.do")
	public String getQaBoard(Integer seq, Model model) {
		QaBoardVO vo = qaBoardService.getQaBoard(seq);
		model.addAttribute("vo", vo);
		return "qaBoard/content";
	}
	
}
