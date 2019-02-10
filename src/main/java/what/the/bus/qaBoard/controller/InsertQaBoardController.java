package what.the.bus.qaBoard.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import what.the.bus.qaBoard.QaBoardVO;
import what.the.bus.qaBoard.service.InsertQaBoardService;

@Controller
public class InsertQaBoardController {
	@Autowired
	private InsertQaBoardService qaboardService;
	
	//게시판 글쓰기 화면으로 이동
	@RequestMapping("/view/**/writeQaBoard.do")
	public String writeQaBoard() {
		return "qaBoard/writeQaForm";
	}
	
	//db에 등록
	@RequestMapping("/view/**/insertQaBoard.do")
	public String insertQaBoard(QaBoardVO vo) {
		qaboardService.insertQaBoard(vo);
		return "redirect:getQaBoardList.do";
	}

}
