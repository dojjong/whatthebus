package what.the.bus.lostComment.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import what.the.bus.lostComment.service.DeleteLostCommentService;

@Controller
public class DeleteLostCommentController {
	
	@Autowired
	private DeleteLostCommentService lostCommentService;
	
	@RequestMapping(value = "/view/**/deleteLostComment.do", method = RequestMethod.POST)
	@ResponseBody
	public String deleteLostComment(@RequestParam int cno) {
		lostCommentService.deleteLostComment(cno);
		return "success";
	}
}
