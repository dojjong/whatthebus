package what.the.bus.noticeComment.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import what.the.bus.noticeComment.NoticeCommentVO;
import what.the.bus.noticeComment.service.UpdateNoticeCommentService;

@Controller
public class UpdateNoticeCommentController {

	@Autowired
	private UpdateNoticeCommentService noticeCommentService;
	
	@RequestMapping(value = "/view/**/updateNoticeCommentCheck.do", method = RequestMethod.POST)
	@ResponseBody
	public String updateNoticeComment(@RequestParam int cno, @RequestParam String content, NoticeCommentVO vo) {
		vo.setCno(cno);
		vo.setContent(content);
		noticeCommentService.updateNoticeComment(vo);
		return "success";
	}
}
