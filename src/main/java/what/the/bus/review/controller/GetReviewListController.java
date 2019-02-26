package what.the.bus.review.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import what.the.bus.driver.DriverVO;
import what.the.bus.driver.service.LoginDriverService;
import what.the.bus.review.ReviewVO;
import what.the.bus.review.service.GetReviewListService;

@Controller
public class GetReviewListController {
	@Autowired
	private GetReviewListService reviewService;
	@Autowired
	private LoginDriverService driverService;

	@RequestMapping("/view/**/getAllReviewList.do")
	public String getAllReviewList(DriverVO vo, Model model) {
		List<ReviewVO> reviewList = reviewService.getAllReviewList();
		model.addAttribute("reviewList", reviewList);
		return "review/reviewList";
	}
}
