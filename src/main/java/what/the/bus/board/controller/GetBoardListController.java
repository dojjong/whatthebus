package what.the.bus.board.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import what.the.bus.board.BoardVO;
import what.the.bus.board.service.GetBoardListService;

@Controller
public class GetBoardListController {
	@Autowired
	private GetBoardListService boardService;

	@RequestMapping("/view/**/getBoardList.do")
	public ModelAndView getBoardList() {
		// boardService.getListCount();
		List<BoardVO> list = boardService.getBoardList();
		ModelAndView mav = new ModelAndView();
		mav.addObject("list", list);
		mav.setViewName("board/list");
		return mav;
	}
}
