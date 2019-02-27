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
	public String deleteBoard(@ModelAttribute BoardVO vo, int seq) {
		vo.setSeq(seq);
		boardService.deleteBoard(vo);
		boardService.deleteComment(vo);
		return "redirect:getBoardList.do";
	}
	@RequestMapping("/view/**/deleteAdminBoard.do")
	public String deleteAdminBoard(@ModelAttribute BoardVO vo, int seq) {
		vo.setSeq(seq);
		vo.setBest(-1);
		boardService.deleteAdminBoard(vo);
		return "redirect:getBoardList.do";
	}
	
}
