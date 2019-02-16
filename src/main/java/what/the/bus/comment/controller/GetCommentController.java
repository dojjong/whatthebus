package what.the.bus.comment.controller;

import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import what.the.bus.comment.CommentVO;
import what.the.bus.comment.service.GetCommentService;

@Controller
public class GetCommentController {
	@Autowired
	private GetCommentService commentService;

	@RequestMapping(value = "/view/**/getComment.do", method = RequestMethod.POST, produces = "application/json; charset=UTF-8")
	@ResponseBody
	public String getComment(@RequestParam int cno, CommentVO vo) {
		JSONObject obj = new JSONObject();
		vo = commentService.getComment(cno);
		obj.put("content", vo.getContent());
		return obj.toString();
	}

}
