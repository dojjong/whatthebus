package what.the.bus.qaComment.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import what.the.bus.qaComment.QaCommentVO;
import what.the.bus.qaComment.service.UpdateQaCommentService;

@Controller
public class UpdateQaCommentController {
	@Autowired
	private UpdateQaCommentService qaCommentService;
	
	@RequestMapping(value = "/view/**/updateQaCommentCheck.do", method = RequestMethod.POST)
	@ResponseBody
	public String updateQaComment(@RequestParam int cno, @RequestParam String content, QaCommentVO vo) {
		vo.setCno(cno);
		vo.setContent(content);
		qaCommentService.updateQaComment(vo);
		return "success";
		
	}
	

}
