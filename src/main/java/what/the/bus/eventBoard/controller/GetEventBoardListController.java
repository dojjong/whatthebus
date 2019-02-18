package what.the.bus.eventBoard.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import what.the.bus.eventBoard.EventBoardVO;
import what.the.bus.eventBoard.service.GetEventBoardListService;
import what.the.bus.eventComment.EventCommentVO;
import what.the.bus.pagination.Pagination;
import what.the.bus.qaBoard.QaBoardVO;

@Controller
public class GetEventBoardListController {

	@Autowired
	private GetEventBoardListService eventboardService;
	
	@RequestMapping("/view/**/getEventBoardList.do")
	public String getEventBoardList(EventBoardVO eventBoardVO, EventCommentVO eventCommentVO, Model model,
			@RequestParam(defaultValue = "1") int curPage, @RequestParam(defaultValue = "") String keyword,
			@RequestParam(defaultValue = "all") String searchOption) {
		
		eventBoardVO.setSearchOption(searchOption);
		eventBoardVO.setKeyword(keyword);
		
		// 전체리스트 개수
		int listCnt = 0;
		if (searchOption.equals("comment")) {
			listCnt = eventboardService.getEventBoardCommentContentListCount(eventCommentVO);
		} else if (searchOption.equals("cname")) {
			listCnt = eventboardService.getEventBoardCommentNameListCount(eventCommentVO);
		} else {
			listCnt = eventboardService.getEventBoardListCount(eventBoardVO);
		}
		
		Pagination pagination = new Pagination(listCnt, curPage);

		int start = pagination.getPageBegin();
		int end = pagination.getPageEnd();
		
		List<EventBoardVO> list = eventboardService.getEventBoardList(start, end, searchOption, keyword);
		
		List<Integer> eventCommentCountList = new ArrayList<Integer>();
		for(int i=0;i<list.size();i++) {
			int seq = list.get(i).getSeq();
			int	eventCommentCount = eventboardService.getEventCommentCount(seq);
			eventCommentCountList.add(i,eventCommentCount);
		}
		
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("commentCount", eventCommentCountList);
		map.put("list", list);
		map.put("searchOption", searchOption);
		map.put("keyword", keyword);
		map.put("count", listCnt);
		map.put("pagination", pagination);
		model.addAttribute("map", map);
		return "eventBoard/list";
		
	}
	
}
