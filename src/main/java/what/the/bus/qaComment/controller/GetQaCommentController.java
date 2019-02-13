package what.the.bus.qaComment.controller;

import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.google.gson.JsonObject;

import what.the.bus.qaComment.QaCommentVO;
import what.the.bus.qaComment.service.GetQaCommentService;

@Controller
public class GetQaCommentController {
	@Autowired
	private GetQaCommentService qaCommentService;
	
	@RequestMapping(value = "/view/**/getQaComment.do", method = RequestMethod.POST, produces = "application/json; charset=UTF-8")
	@ResponseBody
	public String getQaComment(@RequestParam int cno, QaCommentVO vo) {
		JSONObject obj =  new JSONObject();
		vo = qaCommentService.getQaComment(cno);
		obj.put("content", vo.getContent());
		return obj.toString();
	}
	
}
