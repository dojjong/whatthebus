package what.the.bus.suggestBoard.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import what.the.bus.board.BoardVO;
import what.the.bus.comment.CommentVO;
import what.the.bus.pagination.Pagination;
import what.the.bus.suggestBoard.service.GetSuggestBoardListService;

@Controller
public class GetSuggestBoardListController {

	@Autowired
	private GetSuggestBoardListService boardService;

	@RequestMapping("/view/**/getSuggestBoardList.do")
	public String getSuggestBoardList(BoardVO boardVO, CommentVO commentVO, Model model,
			@RequestParam(defaultValue = "1") int curPage, @RequestParam(defaultValue = "") String keyword,
			@RequestParam(defaultValue = "all") String searchOption) {
		// boardService.getListCount();
		boardVO.setSearchOption(searchOption);
		boardVO.setKeyword(keyword);
		
		int listCnt = 0;
		if (searchOption.equals("comment")) {
			listCnt = boardService.getBoardCommentContentListCount(commentVO);
		} else if (searchOption.equals("cname")) {
			listCnt = boardService.getBoardCommentNameListCount(commentVO);
		} else {
			listCnt = boardService.getListCount(boardVO);
		}
		Pagination pagination = new Pagination(listCnt, curPage);
		int start = pagination.getPageBegin();
		int end = pagination.getPageEnd();
		List<BoardVO> list = boardService.getBoardList(start, end, searchOption, keyword);
		List<Integer> commentCountList = new ArrayList<Integer>();
		for (int i = 0; i < list.size(); i++) {
			int seq = list.get(i).getSeq();
			int commentCount = boardService.getCommentCount(seq);
			commentCountList.add(i, commentCount);
		}
		//이부분을 나중에 list갯수 말고 best계산한걸로 불러올것 
		int suggestCount = list.size();
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("commentCount", commentCountList);
		map.put("list", list);
		map.put("searchOption", searchOption);
		map.put("keyword", keyword);
		map.put("count", listCnt);
		map.put("suggestListCount", suggestCount);
		map.put("pagination", pagination);
		model.addAttribute("map", map);
		return "suggestBoard/list";
	}
	/*
	@RequestMapping("/view/dataTransform.do")
	@ResponseBody
	public List<SuggestBoardVO> data(SuggestBoardVO vo) {
		// boardService.getListCount();
		List<SuggestBoardVO> list = suggestBoardService.getSuggestBoardList();
		return list;
	}

	@RequestMapping("/view/cluster.do")
	public String data(Model model) {
		List<SuggestBoardVO> list = suggestBoardService.getSuggestBoardList();
		model.addAttribute("list", list);
		return "suggestBoard/cluster";
	}
	*/
}