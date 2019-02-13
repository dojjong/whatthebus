package what.the.bus.qaBoard.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import what.the.bus.pagination.Pagination;
import what.the.bus.qaBoard.QaBoardVO;
import what.the.bus.qaBoard.service.GetQaBoardListService;
import what.the.bus.qaComment.QaCommentVO;
import what.the.bus.qaComment.dao.QaCommentDAO;

@Controller
public class GetQaBoardListController {

	@Autowired
	private GetQaBoardListService qaBoardService;
	
	@RequestMapping("/view/**/getQaBoardList.do")
	public String getQaBoardList(QaBoardVO qaBoardVO, QaCommentVO qaCommentVO, Model model,
			@RequestParam(defaultValue = "1") int curPage, @RequestParam(defaultValue = "") String keyword,
			@RequestParam(defaultValue = "all") String searchOption) {
		
		qaBoardVO.setSearchOption(searchOption);
		qaBoardVO.setKeyword(keyword);
		
		// 전체리스트 개수
		int listCnt = 0;
		if (searchOption.equals("comment")) {
			listCnt = qaBoardService.getQaBoardCommentContentListCount(qaCommentVO);
		} else if (searchOption.equals("cname")) {
			listCnt = qaBoardService.getQaBoardCommentNameListCount(qaCommentVO);
		} else {
			listCnt = qaBoardService.getQaBoardListCount(qaBoardVO);
		}
		
		Pagination pagination = new Pagination(listCnt, curPage);

		int start = pagination.getPageBegin();
		int end = pagination.getPageEnd();
		
		List<QaBoardVO> list = qaBoardService.getQaBoardList(start, end, searchOption, keyword);
		
		List<Integer> qaCommentCountList = new ArrayList<Integer>();
		for(int i=0;i<list.size();i++) {
			int seq = list.get(i).getSeq();
			int	qaCommentCount = qaBoardService.getQaCommentCount(seq);
			qaCommentCountList.add(i,qaCommentCount);
		}
		
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("commentCount", qaCommentCountList);
		map.put("list", list);
		map.put("searchOption", searchOption);
		map.put("keyword", keyword);
		map.put("count", listCnt);
		map.put("pagination", pagination);
		model.addAttribute("map", map);
		return "qaBoard/list";
		
	}
}
