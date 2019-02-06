package what.the.bus.comment.controller;

import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import what.the.bus.comment.CommentVO;
import what.the.bus.comment.service.UpdateCommentService;

@Controller
public class UpdateCommentController {
	@Autowired
	private UpdateCommentService commentService;

	@RequestMapping(value = "/view/**/updateCommentCheck.do", method = RequestMethod.POST)
	@ResponseBody
	public String updateComment(@RequestParam int cno, @RequestParam String content, CommentVO vo) {
		vo.setCno(cno);
		vo.setContent(content);
		commentService.updateComment(vo);
		return "success";
	}

}
