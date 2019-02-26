package what.the.bus.review.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import what.the.bus.pagination.ReviewPagination;
import what.the.bus.review.ReviewVO;
import what.the.bus.review.service.GetReviewListService;

@Controller
public class GetReviewListController {
	@Autowired
	private GetReviewListService reviewService;

	@RequestMapping("/view/**/getAllReviewList.do")
	public String getAllReviewList(Model model, @RequestParam(defaultValue = "1") int curPage) {
		int listCnt = 0;
		listCnt = reviewService.getAllReviewListCount();
		ReviewPagination pagination = new ReviewPagination(listCnt, curPage);
		int start = pagination.getPageBegin();
		int end = pagination.getPageEnd();
		List<ReviewVO> reviewList = reviewService.getAllReviewList(start, end);
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("reviewList", reviewList);
		map.put("count", listCnt);
		map.put("pagination", pagination);
		model.addAttribute("map", map);

		return "review/reviewList";
	}
}
