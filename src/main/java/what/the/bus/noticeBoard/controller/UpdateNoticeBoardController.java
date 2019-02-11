package what.the.bus.noticeBoard.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import what.the.bus.noticeBoard.NoticeBoardVO;
import what.the.bus.noticeBoard.service.UpdateNoticeBoardService;

@Controller
public class UpdateNoticeBoardController {

	@Autowired
	private UpdateNoticeBoardService noticeBoardService;
	
	@RequestMapping("view/**/updateNoticeForm.do")
	public String updateNoticeForm(int seq, NoticeBoardVO vo, Model model) {
		vo = noticeBoardService.getNoticeBoard(seq);
		model.addAttribute("vo", vo);
		return "noticeBoard/updateNoticeForm";
	}
	
	@RequestMapping("view/**/updateNoticeBoard.do")
	public String updateNoticeBoard(@ModelAttribute NoticeBoardVO vo, int seq) {
		vo.setSeq(seq);
		noticeBoardService.updateNoticeBoard(vo);
		return "redirect:getNoticeBoardList.do";
	}
}
