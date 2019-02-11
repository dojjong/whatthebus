package what.the.bus.noticeBoard.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import what.the.bus.noticeBoard.NoticeBoardVO;
import what.the.bus.noticeBoard.service.DeleteNoticeBoardService;

@Controller
public class DeleteNoticeBoardController {
	@Autowired
	private DeleteNoticeBoardService noticeBoardService;
	
	@RequestMapping("view/**/deleteNoticeBoard.do")
	public String deleteNoticeBoard(@ModelAttribute NoticeBoardVO vo, int seq) {
		vo.setSeq(seq);
		noticeBoardService.deleteNoticeBoard(vo);
		return "redirect:getNoticeBoardList.do";
	}
}
