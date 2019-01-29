package what.the.bus.board.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import what.the.bus.board.BoardVO;
import what.the.bus.board.service.GetBoardService;

@Controller
public class GetBoardController {

	@Autowired
	private GetBoardService boardService;

	@RequestMapping("/view/**/getBoard.do")
	public String getBoard(Integer seq, Model model) {
		BoardVO vo = boardService.getBoard(seq);
		model.addAttribute("vo", vo);
		return "board/content";
	}

}
