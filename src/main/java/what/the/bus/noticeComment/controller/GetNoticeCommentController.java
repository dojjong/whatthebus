package what.the.bus.noticeComment.controller;

import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import what.the.bus.noticeComment.NoticeCommentVO;
import what.the.bus.noticeComment.service.GetNoticeCommentService;

@Controller
public class GetNoticeCommentController {
	@Autowired
	private GetNoticeCommentService noticeCommentService;
	
	@RequestMapping(value = "/view/**/getNoticeComment.do", method = RequestMethod.POST, produces = "application/json; charset=UTF-8")
	@ResponseBody
	public String getNoticeComment(@RequestParam int cno, NoticeCommentVO vo) {
		JSONObject obj = new JSONObject();
		vo = noticeCommentService.getNoticeComment(cno);
		obj.put("content", vo.getContent());
		return obj.toString();
	}
}
