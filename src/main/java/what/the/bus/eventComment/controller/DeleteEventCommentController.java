package what.the.bus.eventComment.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import what.the.bus.eventComment.service.DeleteEventCommentService;

@Controller
public class DeleteEventCommentController {
	
	@Autowired
	private DeleteEventCommentService eventcommentService;
	
	@RequestMapping(value = "/view/**/deleteEventComment.do", method = RequestMethod.POST)
	@ResponseBody
	public String deleteEventComment(@RequestParam int cno) {
		eventcommentService.deleteEventComment(cno);
		return "success";
	}
}
