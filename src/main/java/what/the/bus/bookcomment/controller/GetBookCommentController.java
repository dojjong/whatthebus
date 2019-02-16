package what.the.bus.bookcomment.controller;

import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import what.the.bus.bookcomment.BookCommentVO;
import what.the.bus.bookcomment.service.GetBookCommentService;
@Controller
public class GetBookCommentController {
	@Autowired
	private GetBookCommentService commentService;

	@RequestMapping(value = "/view/**/getBookComment.do", method = RequestMethod.POST, produces = "application/json; charset=UTF-8")
	@ResponseBody
	public String getBookComment(@RequestParam int cno, BookCommentVO vo) {
		JSONObject obj = new JSONObject();
		vo = commentService.getBookComment(cno);
		obj.put("content", vo.getContent());
		return obj.toString();
	}
}
