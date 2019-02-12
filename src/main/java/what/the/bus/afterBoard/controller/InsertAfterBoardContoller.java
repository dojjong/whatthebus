package what.the.bus.afterBoard.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import what.the.bus.afterBoard.AfterBoardVO;
import what.the.bus.afterBoard.service.InsertAfterBoardService;

@Controller
public class InsertAfterBoardContoller {

	@Autowired
	private InsertAfterBoardService afterBoardService;
	
	//게시판 글쓰기
	@RequestMapping(value="/view/**/writeAfterBoard.do", method=RequestMethod.GET)
	public String writeAfterBoard() {
		return "afterBoard/writeAfterForm";
	}
	
	@RequestMapping(value="/view/**/insertAfterBoard.do", method=RequestMethod.POST)
	public String insertAfterBoard(@ModelAttribute AfterBoardVO vo) throws Exception{
		afterBoardService.insertAfterBoard(vo);
		return "redirect:getAfterBoardList.do";
	}
	
}
