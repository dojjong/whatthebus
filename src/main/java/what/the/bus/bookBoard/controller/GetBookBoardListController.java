package what.the.bus.bookBoard.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import what.the.bus.bookBoard.service.GetBookBoardListService;
import what.the.bus.bookcomment.BookCommentVO;
import what.the.bus.pagination.Pagination;
import what.the.bus.suggestBoard.SuggestBoardVO;

@Controller
public class GetBookBoardListController {
	@Autowired
	private GetBookBoardListService bookBoardService;

	@RequestMapping("/view/**/getBookBoardList.do")
	public String getBookBoardList(SuggestBoardVO suggestVO, BookCommentVO commentVO, Model model,
			@RequestParam(defaultValue = "1") int curPage, @RequestParam(defaultValue = "") String keyword,
			@RequestParam(defaultValue = "all") String searchOption) {
		// boardService.getListCount();
		suggestVO.setSearchOption(searchOption);
		suggestVO.setKeyword(keyword);

		// 전체리스트 개수
		int listCnt = 0;
		if (searchOption.equals("comment")) {
			listCnt = bookBoardService.getBoardCommentContentListCount(commentVO);
		} else if (searchOption.equals("cname")) {
			listCnt = bookBoardService.getBoardCommentNameListCount(commentVO);
		} else {
			listCnt = bookBoardService.getBookBoardListCount(suggestVO);
		}

		Pagination pagination = new Pagination(listCnt, curPage);

		int start = pagination.getPageBegin();
		int end = pagination.getPageEnd();

		List<SuggestBoardVO> list = bookBoardService.getBookBoardList(start, end, searchOption, keyword);
		List<Integer> commentCountList = new ArrayList<Integer>();
		for (int i = 0; i < list.size(); i++) {
			int seq = list.get(i).getSeq();
			int commentCount = bookBoardService.getCommentCount(seq);
			commentCountList.add(i, commentCount);
		}
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("commentCount", commentCountList);
		map.put("list", list);
		map.put("searchOption", searchOption);
		map.put("keyword", keyword);
		map.put("count", listCnt);
		map.put("pagination", pagination);
		model.addAttribute("map", map);
		return "bookBoard/list";
	}
}