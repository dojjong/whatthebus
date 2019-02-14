package what.the.bus.reply.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import what.the.bus.reply.ReplyVO;
import what.the.bus.reply.service.GetReplyListService;

@RestController
public class GetReplyListController {

	@Autowired
	GetReplyListService getReplyListService;
	
	//댓글 목록(view)
	@RequestMapping("/view/**/getReplyList.do")
	public String getReplyList(@RequestParam int seq, Model model) throws Exception{
		List<ReplyVO> list = getReplyListService.getReplyList(seq);
		model.addAttribute("list",list);
		System.out.println(list.size()+"댓글목록창");
		return "reply/replyList";
	}
	
	//댓글목록(json)
	@RequestMapping("/view/**/getReplyListJson.do")
	@ResponseBody
	public List<ReplyVO> getReplyListJson(@RequestParam int seq) throws Exception{
		List<ReplyVO> list = getReplyListService.getReplyList(seq);
		return list;
	}
}
