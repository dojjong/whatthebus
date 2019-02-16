package what.the.bus.bookcomment.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import what.the.bus.bookcomment.BookCommentVO;
import what.the.bus.bookcomment.service.UpdateBookCommentService;

@Controller
public class UpdateBookCommentContoller {
	@Autowired
	private UpdateBookCommentService commentService;

	@RequestMapping(value = "/view/**/updateBookCommentCheck.do", method = RequestMethod.POST)
	@ResponseBody
	public String updateBookComment(@RequestParam int cno, @RequestParam String content, BookCommentVO vo) {
		vo.setCno(cno);
		vo.setContent(content);
		commentService.updateBookComment(vo);
		return "success";
	}

}
