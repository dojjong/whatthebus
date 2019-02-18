package what.the.bus.eventComment.controller;

import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import what.the.bus.eventComment.EventCommentVO;
import what.the.bus.eventComment.service.GetEventCommentService;

@Controller
public class GetEventCommentController {

	@Autowired
	private GetEventCommentService eventcommentService;
	
	@RequestMapping(value = "/view/**/getEventComment.do", method = RequestMethod.POST, produces = "application/json; charset=UTF-8")
	@ResponseBody
	public String getEventComment(@RequestParam int cno, EventCommentVO vo) {
		JSONObject obj =  new JSONObject();
		vo = eventcommentService.getEventComment(cno);
		obj.put("content", vo.getContent());
		return obj.toString();
	}
}
