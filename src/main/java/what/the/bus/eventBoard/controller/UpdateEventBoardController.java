package what.the.bus.eventBoard.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import what.the.bus.eventBoard.EventBoardVO;
import what.the.bus.eventBoard.service.UpdateEventBoardService;


@Controller
public class UpdateEventBoardController {

	@Autowired
	private UpdateEventBoardService eventboardService;
	
	@RequestMapping("view/**/updateEventForm.do")
	public String updateEventForm(int seq, EventBoardVO vo, Model model) {
		vo = eventboardService.getEventBoard(seq);
		model.addAttribute("vo", vo);
		return "eventBoard/updateEventForm";
	}
	
	@RequestMapping("view/**/updateEventBoard.do")
	public String updateEventBoard(@ModelAttribute EventBoardVO vo, int seq) {
		vo.setSeq(seq);
		eventboardService.updateEventBoard(vo);
		return "redirect:getEventBoardList.do";
	}
	
	
}
