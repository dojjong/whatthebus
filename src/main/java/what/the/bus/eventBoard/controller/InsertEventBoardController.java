package what.the.bus.eventBoard.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import what.the.bus.eventBoard.EventBoardVO;
import what.the.bus.eventBoard.service.InsertEventBoardService;

@Controller
public class InsertEventBoardController {

	@Autowired
	private InsertEventBoardService eventboardService;
	
	//게시판 글쓰기 화면으로 이동
	@RequestMapping("/view/**/writeEventBoard.do")
	public String writeEventBoard() {
		return "eventBoard/writeEventForm";
	}
	
	//db에 등록
	@RequestMapping("/view/**/insertEventBoard.do")
	public String insertEventBoard(EventBoardVO vo) {
		eventboardService.insertEventBoard(vo);
		return "redirect:getEventBoardList.do";
	}
}
