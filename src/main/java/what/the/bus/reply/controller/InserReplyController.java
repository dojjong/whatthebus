package what.the.bus.reply.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import what.the.bus.reply.ReplyVO;
import what.the.bus.reply.service.InsertReplyService;

@RestController
public class InserReplyController {
	
	@Autowired
	InsertReplyService insertReplyService;
	
	//댓글 입력
	@RequestMapping("/view/**/insertReply.do")
	public void insertReply(@RequestParam String id, @RequestParam int seq, @RequestParam String replyText, @RequestParam String name, @ModelAttribute ReplyVO vo, HttpSession session) {
		System.out.println("컨트롤러 입력완료1");
		String sessionID = (String) session.getAttribute("id");
		System.out.println("sessionID="+sessionID);
		vo.setId(id);
		vo.setContent(replyText);
		vo.setSeq(seq);
		vo.setName(name);
		insertReplyService.insertReply(vo);
		System.out.println("컨트롤러 입력완료2");
		
	}
}
