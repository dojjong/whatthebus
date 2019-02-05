package what.the.bus.comment.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import what.the.bus.comment.service.DeleteCommentService;

@Controller
public class DeleteCommentController {
	@Autowired
	private DeleteCommentService commentService;

	@RequestMapping(value = "/view/**/deleteComment.do", method = RequestMethod.POST)
	@ResponseBody
	public String deleteComment(@RequestParam int cno) {
		commentService.deleteComment(cno);
		return "success";
	}

}
