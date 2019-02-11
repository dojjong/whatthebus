package what.the.bus.noticeBoard.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import what.the.bus.noticeBoard.NoticeBoardVO;
import what.the.bus.noticeBoard.service.InsertNoticeBoardService;

@Controller
public class InsertNoticeBoardController {
	@Autowired
	private InsertNoticeBoardService noticeBoardService;
	
	@RequestMapping("view/**/writeNoticeBoard.do")
	public String writeNoticeBoard() {
		return "noticeBoard/writeNoticeForm";
	}
	
	@RequestMapping("view/**/insertNoticeBoard.do")
	public String insertNoticeBoard(NoticeBoardVO vo) {
		noticeBoardService.insertNoticeBoard(vo);
		return "redirect:getNoticeBoardList.do";
	}
	

}
