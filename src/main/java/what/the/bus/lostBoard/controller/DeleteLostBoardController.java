package what.the.bus.lostBoard.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import what.the.bus.lostBoard.LostBoardVO;
import what.the.bus.lostBoard.service.DeleteLostBoardService;

@Controller
public class DeleteLostBoardController {
	
	@Autowired
	private DeleteLostBoardService lostBoardService;
	
	@RequestMapping("view/**/deleteLostBoard.do")
	public String deleteLostBoard(@ModelAttribute LostBoardVO vo, int seq) {
		vo.setSeq(seq);
		lostBoardService.deleteLostBoard(vo);
		
		return "redirect:getLostBoardList.do";
	}
}
