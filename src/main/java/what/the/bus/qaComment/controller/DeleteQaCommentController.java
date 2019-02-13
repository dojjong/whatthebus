package what.the.bus.qaComment.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import what.the.bus.qaComment.service.DeleteQaCommentService;

@Controller
public class DeleteQaCommentController {
	@Autowired
	private DeleteQaCommentService qaCommentService;
	
	@RequestMapping(value = "/view/**/deleteQaComment.do", method = RequestMethod.POST)
	@ResponseBody
	public String deleteQaComment(@RequestParam int cno) {
		qaCommentService.deleteQaComment(cno);
		return "success";
	}
}
