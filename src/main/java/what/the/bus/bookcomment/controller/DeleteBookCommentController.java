package what.the.bus.bookcomment.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import what.the.bus.bookcomment.service.DeleteBookCommentService;
@Controller
public class DeleteBookCommentController {
	@Autowired
	private DeleteBookCommentService commentService;

	@RequestMapping(value = "/view/**/deleteBookComment.do", method = RequestMethod.POST)
	@ResponseBody
	public String deleteBookComment(@RequestParam int cno) {
		commentService.deleteBookComment(cno);
		return "success";
	}

}
