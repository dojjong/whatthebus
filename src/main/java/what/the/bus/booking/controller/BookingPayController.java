package what.the.bus.booking.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import what.the.bus.bookBoard.service.GetBookBoardService;
import what.the.bus.booking.BookingPayVO;
import what.the.bus.booking.service.BookingPayService;
import what.the.bus.member.MemberVO;
import what.the.bus.pagination.Pagination;
import what.the.bus.review.ReviewVO;
import what.the.bus.review.service.GetReviewListService;
import what.the.bus.suggestBoard.SuggestBoardVO;

@Controller
public class BookingPayController {
	@Autowired
	private GetBookBoardService bookBoardService;
	@Autowired
	private BookingPayService bookingPayService;
	@Autowired
	private GetReviewListService reviewService;

	@RequestMapping("/view/**/bookingTicket.do")
	public String bookingTicket(Integer seq, Model model) {
		SuggestBoardVO vo = bookBoardService.getBookBoard(seq);
		List<Integer> busSit = bookingPayService.getSitNumList(seq);

		model.addAttribute("bussit", busSit);
		model.addAttribute("vo", vo);
		return "booking/bookingForm";
	}

	@RequestMapping("/view/**/bookingPay.do")
	public String bookingPay(BookingPayVO vo, Model model) {
		bookingPayService.insertBookingPay(vo);
		model.addAttribute("vo", vo);
		return "booking/successPay";
	}

	@RequestMapping("/view/**/getBookingPayList.do")
	public String getBookingPayList(BookingPayVO bookingPayVO, ReviewVO reviewVO, Model model, HttpSession session,
			@RequestParam(defaultValue = "1") int curPage) {
		String id;
		MemberVO vo;
		vo = (MemberVO) session.getAttribute("member");
		id = vo.getId();
		bookingPayVO.setId(id);
		reviewVO.setId(id);

		int listCnt = 0;
		listCnt = bookingPayService.getBookingPayListCount(bookingPayVO);
		Pagination pagination = new Pagination(listCnt, curPage);
		int start = pagination.getPageBegin();
		int end = pagination.getPageEnd();
		List<BookingPayVO> list = bookingPayService.getBookingPayList(start, end, id);
		List<Integer> reviewCount = new ArrayList<Integer>();
		int check = 0;
		for (int i = 0; i < list.size(); i++) {
			reviewVO.setBusseq(list.get(i).getBusseq());
			check = reviewService.getReviewCount(reviewVO);
			reviewCount.add(i, check);
		}
		System.out.println(reviewCount.toString());
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("reviewCount", reviewCount);
		map.put("list", list);
		map.put("count", listCnt);
		map.put("pagination", pagination);
		model.addAttribute("map", map);

		return "member/member_getBookingPayList";
	}

}
