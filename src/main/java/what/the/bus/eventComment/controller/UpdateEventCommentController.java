package what.the.bus.eventComment.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import what.the.bus.eventComment.EventCommentVO;
import what.the.bus.eventComment.service.UpdateEventCommentService;

@Controller
public class UpdateEventCommentController {

	@Autowired
	private UpdateEventCommentService eventcommentService;
	
	@RequestMapping(value = "/view/**/updateEventCommentCheck.do", method = RequestMethod.POST)
	@ResponseBody
	public String updateEventComment(@RequestParam int cno, @RequestParam String content, EventCommentVO vo) {
		vo.setCno(cno);
		vo.setContent(content);
		eventcommentService.updateEventComment(vo);
		return "success";
		
	}
}
