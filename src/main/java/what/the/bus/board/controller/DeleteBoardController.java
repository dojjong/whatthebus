package what.the.bus.board.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import what.the.bus.board.BoardVO;
import what.the.bus.board.service.DeleteBoardService;

@Controller
public class DeleteBoardController {
	@Autowired
	private DeleteBoardService boardService;

	@RequestMapping("/view/**/deleteBoard.do")
	public String updateBoard(@ModelAttribute BoardVO vo, int seq) {
		vo.setSeq(seq);
		boardService.deleteBoard(vo);
		return "redirect:getBoardList.do";
	}

}
