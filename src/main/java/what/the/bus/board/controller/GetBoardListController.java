package what.the.bus.board.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import what.the.bus.board.BoardVO;
import what.the.bus.board.service.GetBoardListService;
import what.the.bus.pagination.Pagination;

@Controller
public class GetBoardListController {
	@Autowired
	private GetBoardListService boardService;

	@RequestMapping("/view/**/getBoardList.do")
	public String getBoardList(BoardVO boardVO, Model model, @RequestParam(defaultValue = "1") int curPage,
			@RequestParam(defaultValue = "") String keyword,
			@RequestParam(defaultValue = "all") String searchOption) {

		boardVO.setSearchOption(searchOption);
		boardVO.setKeyword(keyword);
		// 전체리스트 개수
		int listCnt = boardService.getListCount(boardVO);

		Pagination pagination = new Pagination(listCnt, curPage);

		boardVO.setStartIndex(pagination.getStartIndex() + 1);
		boardVO.setCntPerPage(pagination.getStartIndex() + pagination.getPageSize());
		List<BoardVO> list = boardService.getBoardList(boardVO);
		model.addAttribute("list", list);
		model.addAttribute("listCount", listCnt);
		model.addAttribute("pagination", pagination);
		return "board/list";
	}
}
