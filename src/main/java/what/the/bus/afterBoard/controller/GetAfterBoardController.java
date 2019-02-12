package what.the.bus.afterBoard.controller;


import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import what.the.bus.afterBoard.AfterBoardVO;
import what.the.bus.afterBoard.service.GetAfterBoardService;
@Controller
public class GetAfterBoardController {
	@Autowired
	private GetAfterBoardService afterBoardService;

	@RequestMapping(value="/view/**/getAfterBoard.do", method=RequestMethod.GET)
	public String getAfterBoard(@RequestParam int seq, HttpSession session, Model model) throws Exception {
		afterBoardService.increaseViewCnt(seq, session);
		AfterBoardVO vo = afterBoardService.getAfterBoard(seq);
		System.out.println(seq);
		model.addAttribute("vo", vo);
		return "afterBoard/content";
	}
}
