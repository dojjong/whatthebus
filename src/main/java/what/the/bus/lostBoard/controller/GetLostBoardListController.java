package what.the.bus.lostBoard.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import what.the.bus.lostBoard.LostBoardVO;
import what.the.bus.lostBoard.service.GetLostBoardListService;
import what.the.bus.lostComment.LostCommentVO;
import what.the.bus.pagination.Pagination;

@Controller
public class GetLostBoardListController {
	
	@Autowired
	private GetLostBoardListService lostBoardService;
	
	@RequestMapping("/view/**/getLostBoardList.do")
	public String getLostBoardList(LostBoardVO lostBoardVO, LostCommentVO lostCommentVO, Model model,
			@RequestParam(defaultValue = "1") int curPage, @RequestParam(defaultValue = "") String keyword,
			@RequestParam(defaultValue = "all") String searchOption) {
	
		lostBoardVO.setSearchOption(searchOption);
		lostBoardVO.setKeyword(keyword);
	
		//전체 리스트 개수
		int listCnt = 0;
		if(searchOption.equals("comment")) {
			listCnt = lostBoardService.getLostBoardCommentContentListCount(lostCommentVO);
		} else if(searchOption.equals("cname")) {
			listCnt = lostBoardService.getLostBoardCommentNameListCount(lostCommentVO);
		} else {
			listCnt = lostBoardService.getLostBoardListCount(lostBoardVO);
		}
		
		Pagination pagination = new Pagination(listCnt, curPage);
		
		int start = pagination.getPageBegin();
		int end = pagination.getPageEnd();
		
		List<LostBoardVO> list = lostBoardService.getLostBoardList(start, end, searchOption, keyword);
		
		List<Integer> lostCommentCountList = new ArrayList<Integer>();
		for(int i=0; i<list.size(); i++) {
			int seq = list.get(i).getSeq();
			int lostCommentCount = lostBoardService.getLostCommentCount(seq);
			lostCommentCountList.add(i, lostCommentCount);
		}
		
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("commentCount", lostCommentCountList);
		map.put("list", list);
		map.put("searchOption", searchOption);
		map.put("keyword", keyword);
		map.put("count", listCnt);
		map.put("pagination", pagination);
		model.addAttribute("map", map); 
		return "lostBoard/list";
		
		
		
		
		
		
		
		
		
		
		
		
		
	}
}
