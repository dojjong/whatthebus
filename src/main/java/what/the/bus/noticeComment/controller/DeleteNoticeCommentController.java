package what.the.bus.noticeComment.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import what.the.bus.noticeComment.service.DeleteNoticeCommentService;

@Controller
public class DeleteNoticeCommentController {
	@Autowired
	private DeleteNoticeCommentService noticeCommentService;
	
	@RequestMapping(value = "/view/**/deleteNoticeComment.do", method = RequestMethod.POST)
	@ResponseBody
	public String deleteNoticeComment(@RequestParam int cno) {
		noticeCommentService.deleteNoticeComment(cno);
		return "success";
	}
}
