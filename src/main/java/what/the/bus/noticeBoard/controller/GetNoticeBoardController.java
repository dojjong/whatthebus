package what.the.bus.noticeBoard.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import what.the.bus.noticeBoard.NoticeBoardVO;
import what.the.bus.noticeBoard.service.GetNoticeBoardService;

@Controller
public class GetNoticeBoardController {
	@Autowired
	private GetNoticeBoardService noticeBoardService;
	
	@RequestMapping("view/**/getNoticeBoard.do")
	public String getNoticeBoard(Integer seq, Model model) {
		NoticeBoardVO vo = noticeBoardService.getNoticeBoard(seq);
		model.addAttribute("vo", vo);
		return "noticeBoard/content";
	}

}
