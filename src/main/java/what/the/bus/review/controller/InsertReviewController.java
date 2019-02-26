package what.the.bus.review.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import what.the.bus.bookBoard.service.GetBookBoardService;
import what.the.bus.booking.service.BookingPayService;
import what.the.bus.review.ReviewVO;
import what.the.bus.review.service.InsertReviewService;
import what.the.bus.suggestBoard.SuggestBoardVO;

@Controller
public class InsertReviewController {

	@Autowired
	private GetBookBoardService bookBoardService;
	@Autowired
	private InsertReviewService insertReviewService;
	
	

	@RequestMapping("/view/**/moveReview.do")
	@ResponseBody
	public String moveReview(int busseq) {
		return "success";
	}

	@RequestMapping("/view/**/moveReviewForm.do")
	public String moveReviewForm(@RequestParam int busseq, Model model, HttpSession session) {
		// 해당 버스 정보 가져오고 리스트에 넣어준뒤 뷰에 뿌려줄 것
		SuggestBoardVO vo = bookBoardService.getBookBoard(busseq);
		model.addAttribute("vo", vo);

		return "review/reviewForm";
	}

	@RequestMapping("/view/**/insertReview.do")
	@ResponseBody
	public String insertReview(ReviewVO vo) {
		insertReviewService.inserReview(vo);
		return "success";
	}

}
