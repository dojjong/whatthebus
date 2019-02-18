package what.the.bus.suggestBoard.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import what.the.bus.board.BoardVO;
import what.the.bus.suggestBoard.SuggestBoardVO;
import what.the.bus.suggestBoard.service.InsertSuggestBoardService;

@Controller
public class InsertSuggestBoardController {
	@Autowired
	private InsertSuggestBoardService suggestBoardService;
	
	
	//�Խ��� �۾���
	@RequestMapping("/view/**/writeSuggestBoard.do")
	public String writeSuggestBoard() {
		return "suggestBoard/writeSuggestForm";
	}
	
	@RequestMapping("/view/**/insertSuggestBoard.do")
	public String insertSuggestBoard(BoardVO vo) {
		if(vo.getMiddate()==null) {
			vo.setMiddate("00:00");
		}
		System.out.println(vo.getBus());
		System.out.println(vo.getBest());
		System.out.println(vo.getTotalbest());
		System.out.println(vo.getSeq());
		suggestBoardService.totalBestCount(vo);
		suggestBoardService.insertSuggestBoard(vo);
		return "redirect:getSuggestBoardList.do";
	}

}