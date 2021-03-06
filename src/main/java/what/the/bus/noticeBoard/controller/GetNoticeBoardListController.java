package what.the.bus.noticeBoard.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import what.the.bus.noticeBoard.NoticeBoardVO;
import what.the.bus.noticeBoard.service.GetNoticeBoardListService;
import what.the.bus.noticeComment.NoticeCommentVO;
import what.the.bus.pagination.Pagination;



@Controller
public class GetNoticeBoardListController {

	@Autowired
	private GetNoticeBoardListService noticeBoardListService;
	
	
	@RequestMapping("/view/**/getNoticeBoardList.do")
	public String getQaBoardList(NoticeBoardVO noticeBoardVO, NoticeCommentVO noticeCommentVO, Model model,
			@RequestParam(defaultValue = "1") int curPage, @RequestParam(defaultValue = "") String keyword,
			@RequestParam(defaultValue = "all") String searchOption) {
		
		noticeBoardVO.setSearchOption(searchOption);
		noticeBoardVO.setKeyword(keyword);
		
		// 전체리스트 개수
		int listCnt = 0;
		if (searchOption.equals("comment")) {
			listCnt = noticeBoardListService.getNoticeCommentContentListCount(noticeCommentVO);
		} else if (searchOption.equals("cname")) {
			listCnt = noticeBoardListService.getNoticeCommentNameListCount(noticeCommentVO);
		} else {
			listCnt = noticeBoardListService.getNoticeBoardListCount(noticeBoardVO);
		}
		
		Pagination pagination = new Pagination(listCnt, curPage);

		int start = pagination.getPageBegin();
		int end = pagination.getPageEnd();
		
		List<NoticeBoardVO> list = noticeBoardListService.getNoticeBoardList(start, end, searchOption, keyword);
		
		List<Integer> noticeCommentCountList = new ArrayList<Integer>();
		for(int i=0;i<list.size();i++) {
			int seq = list.get(i).getSeq();
			int	noticeCommentCount = noticeBoardListService.getNoticeCommentCount(seq);
			noticeCommentCountList.add(i,noticeCommentCount);
		}
		
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("commentCount", noticeCommentCountList);
		map.put("list", list);
		map.put("searchOption", searchOption);
		map.put("keyword", keyword);
		map.put("count", listCnt);
		map.put("pagination", pagination);
		model.addAttribute("map", map);
		return "noticeBoard/list";
		
	}
	

	
}
