package what.the.bus.eventBoard.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import what.the.bus.eventBoard.EventBoardVO;
import what.the.bus.eventBoard.service.DeleteEventBoardService;

@Controller
public class DeleteEventBoardController {

	@Autowired
	private DeleteEventBoardService eventboardService;
	
	@RequestMapping("view/**/deleteEventBoard.do")
	public String deleteEventBoard(@ModelAttribute EventBoardVO vo, int seq) {
		vo.setSeq(seq);
		eventboardService.deleteEvnetBoard(vo);
		eventboardService.deleteEventComment(vo);
		return "redirect:getEventBoardList.do";
	}
	
}
