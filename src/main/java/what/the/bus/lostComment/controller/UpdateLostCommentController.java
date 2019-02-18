package what.the.bus.lostComment.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import what.the.bus.lostComment.LostCommentVO;
import what.the.bus.lostComment.service.UpdateLostCommentService;

@Controller
public class UpdateLostCommentController {

	@Autowired
	private UpdateLostCommentService lostCommentService;
	
	@RequestMapping(value = "/view/**/updateLostCommentCheck.do", method = RequestMethod.POST)
	@ResponseBody
	public String updateLostComment(@RequestParam int cno, @RequestParam String content, LostCommentVO vo) {
		vo.setCno(cno);
		vo.setContent(content);
		lostCommentService.updateLostComment(vo);
		return "success";
	}

}