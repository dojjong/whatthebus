package what.the.bus.board.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import what.the.bus.admin.service.GetBestCountService;
import what.the.bus.board.BoardVO;
import what.the.bus.board.ChartVO1;
import what.the.bus.board.service.GetBoardListService;
import what.the.bus.comment.CommentVO;
import what.the.bus.pagination.Pagination;

@Controller
public class GetBoardListController {
	@Autowired
	private GetBoardListService boardService;
	@Autowired
	private GetBestCountService bestService;
	@RequestMapping("/view/**/getBoardList.do")
	public String getBoardList(BoardVO boardVO, CommentVO commentVO, Model model,
			@RequestParam(defaultValue = "1") int curPage, @RequestParam(defaultValue = "") String keyword,
			@RequestParam(defaultValue = "all") String searchOption) {

		boardVO.setSearchOption(searchOption);
		boardVO.setKeyword(keyword);
		//여기 바꿀것. (관리자에서)
		boardVO.setBestcount(1);
		// 전체리스트 개수
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
		int bestcount = bestService.getBestCount();
		List<BoardVO> list = boardService.getBoardList(start, end, searchOption, keyword);
		List<Integer> commentCountList = new ArrayList<Integer>();
		for(int i=0;i<list.size();i++) {
			int seq = list.get(i).getSeq();
			int	commentCount = boardService.getCommentCount(seq);
			commentCountList.add(i,commentCount);
		}
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("bestcount", bestcount);
		map.put("commentCount", commentCountList);
		map.put("list", list);
		map.put("searchOption", searchOption);
		map.put("keyword", keyword);
		map.put("count", listCnt);
		map.put("pagination", pagination);
		model.addAttribute("map", map);
		return "board/list";
	}
	
	//차트1 view
	@RequestMapping("/view/**/getBoardCountPerRegdate.do")
	public String getBoardCountPerRegdateJson() throws Exception{
		System.out.println("getBoardCountPerRegdate");
		return "chart/dateBasedData";
	}

	//차트1 json
	@RequestMapping("/view/**/getBoardCountPerRegdateJson.do")
	@ResponseBody
	public List<ChartVO1> getBoardCountPerRegdateJson(Model model) {
		List<ChartVO1> list = boardService.getBoardCountPerRegdate();
		return list;
	}

}
