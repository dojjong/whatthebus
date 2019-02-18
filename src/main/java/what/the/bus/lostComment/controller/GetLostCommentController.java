package what.the.bus.lostComment.controller;

import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import what.the.bus.lostComment.LostCommentVO;
import what.the.bus.lostComment.service.GetLostCommentService;

@Controller
public class GetLostCommentController {
	
	@Autowired
	private GetLostCommentService lostCommentService;
	
	@RequestMapping(value = "/view/**/getLostComment.do", method = RequestMethod.POST, produces = "application/json; charset=UTF-8")
	@ResponseBody
	public String getLostComment(@RequestParam int cno, LostCommentVO vo) {
		JSONObject obj = new JSONObject();
		vo = lostCommentService.getLostComment(cno);
		obj.put("content", vo.getContent());
		return obj.toString();
	}
}
