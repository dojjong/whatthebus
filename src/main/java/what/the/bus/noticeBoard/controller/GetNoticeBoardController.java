package what.the.bus.noticeBoard.controller;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import what.the.bus.noticeBoard.NoticeBoardVO;
import what.the.bus.noticeBoard.service.GetNoticeBoardService;

@Controller
public class GetNoticeBoardController {
	@Autowired
	private GetNoticeBoardService noticeBoardService;
	
	@RequestMapping("view/**/getNoticeBoard.do")
	public String getNoticeBoard(Integer seq, String id, @RequestParam(defaultValue ="1") int curPage,
			@RequestParam(defaultValue = "") String keyword, @RequestParam(defaultValue = "all") String searchOption, Model model) {
		NoticeBoardVO vo = noticeBoardService.getNoticeBoard(seq);
		//System.out.println(vo.toString());
		
	
		
		model.addAttribute("searchOption", searchOption);
		model.addAttribute("keyword", keyword);
		model.addAttribute("curPage", curPage);
		model.addAttribute("vo", vo);
		
		return "noticeBoard/content";
	}

}
