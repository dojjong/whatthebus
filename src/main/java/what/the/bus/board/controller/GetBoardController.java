package what.the.bus.board.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import what.the.bus.best.BestVO;
import what.the.bus.board.BoardVO;
import what.the.bus.board.service.GetBoardService;

@Controller
public class GetBoardController {

	@Autowired
	private GetBoardService boardService;

	@RequestMapping("/view/**/getBoard.do")
	public String getBoard(Integer seq, String id, BestVO bestVO, @RequestParam(defaultValue = "1") int curPage,
			@RequestParam(defaultValue = "") String keyword, @RequestParam(defaultValue = "all") String searchOption,
			Model model) {
		BoardVO boardVO = boardService.getBoard(seq);

		int check = 0;

		bestVO.setId(id);
		bestVO.setSeq(seq);
		
		check = boardService.getCheckBest(bestVO);
		if (check == 1) {
			check = boardService.getCheckBestCheck(bestVO);
		}
		model.addAttribute("searchOption", searchOption);
		model.addAttribute("keyword", keyword);
		model.addAttribute("curPage", curPage);
		model.addAttribute("best", check);
		model.addAttribute("vo", boardVO);
		return "board/content";
	}

}
