package what.the.bus.noticeBoard.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import what.the.bus.noticeBoard.NoticeBoardVO;
import what.the.bus.noticeBoard.service.GetNoticeBoardListService;


@Controller
public class GetNoticeBoardListController {

	@Autowired
	private GetNoticeBoardListService noticeBoardListService;
	
	@RequestMapping("view/**/getNoticeBoardList.do")
	public String getNoticeBoardList(Model model) {
		List<NoticeBoardVO> list = noticeBoardListService.getNoticeBoardList();
		model.addAttribute("list", list);
		return "noticeBoard/list";
	}
	
}
