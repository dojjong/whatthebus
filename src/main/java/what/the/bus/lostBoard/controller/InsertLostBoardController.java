package what.the.bus.lostBoard.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import what.the.bus.lostBoard.LostBoardVO;
import what.the.bus.lostBoard.service.InsertLostBoardService;

@Controller
public class InsertLostBoardController {
	@Autowired
	private InsertLostBoardService lostboardService;
	
	//게시판 글쓰기 화면으로 이동
	@RequestMapping("/view/**/writeLostBoard.do")
	public String writeLostBoard() {
		return "lostBoard/writeLostForm";
	}
	
	//db에 등록
	@RequestMapping("/view/**/insertLostBoard.do")
	public String insertLostBoard(LostBoardVO vo) {
		lostboardService.insertLostBoard(vo);
		return "redirect:getLostBoardList.do";
	}
}
