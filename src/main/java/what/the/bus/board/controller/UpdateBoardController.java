package what.the.bus.board.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import what.the.bus.board.BoardVO;
import what.the.bus.board.service.UpdateBoardService;

@Controller
public class UpdateBoardController {
	@Autowired
	private UpdateBoardService boardService;

	@RequestMapping("/view/**/updateForm.do")
	public String updateForm(int seq,BoardVO vo,Model model) {
		vo = boardService.getBoard(seq);
		model.addAttribute("vo", vo);
		return "board/updateForm";
	}
	
	
	@RequestMapping("/view/**/updateBoard.do")
	public String updateBoard(@ModelAttribute BoardVO vo,int seq) {
		vo.setSeq(seq);
		boardService.updateBoard(vo);
		return "redirect:getBoardList.do";
	}

}
