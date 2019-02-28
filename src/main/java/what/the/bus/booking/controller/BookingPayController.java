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
import what.the.bus.driver.DriverVO;
import what.the.bus.mail.service.MailService;
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
	@Autowired
	private MailService mailService;

	@RequestMapping("/view/**/bookingTicket.do")
	public String bookingTicket(Integer seq, Model model) {
		SuggestBoardVO vo = bookBoardService.getBookBoard(seq);
		List<Integer> busSit = bookingPayService.getSitNumList(seq);

		model.addAttribute("bussit", busSit);
		model.addAttribute("vo", vo);
		return "booking/bookingForm";
	}

	@RequestMapping("/view/**/bookingPay.do")
	public String bookingPay(BookingPayVO vo, Model model, HttpSession session) {

		bookingPayService.insertBookingPay(vo);
		model.addAttribute("vo", vo);

		// javax.mail.Message.setContent("메일 본문 내용 HTML 코딩",
		// "text/html;charset=euc-kr");
		String email = "";
		if (session.getAttribute("member").getClass() == MemberVO.class) {
			MemberVO mvo = (MemberVO) session.getAttribute("member");
			email = mvo.getEmail();
		} else if (session.getAttribute("member").getClass() == DriverVO.class) {
			DriverVO dvo = (DriverVO) session.getAttribute("member");
			email = dvo.getEmail();
		} else {
			System.out.println("뭐가문젠겨 대체");
		}

		SuggestBoardVO svo = bookBoardService.getBookBoard(vo.getBusseq());

		String title = "WTB 결제 확인 메일입니다.";
		String content = "<table>" + "<tr><td colspan='2'>회원님께서 결제하신 내역입니다.</td></tr>" + "<tr><td></td></tr>"
				+ "<tr><td>게시글번호 </td><td>" + vo.getBusseq() + "</td></tr>" + "<tr><td>게시글제목 </td><td>" + svo.getTitle()
				+ "</td></tr>" + "<tr><td>기사님 성함 </td><td>" + svo.getName() + "기사님</td></tr>" + "<tr><td>출발일시 </td><td>"
				+ svo.getStartdate() + "</td></tr>" + "<tr><td>운행예상소요시간 </td><td>" + svo.getFinishtime() + "분</td></tr>"
				+ "<tr><td>신청고객님  </td><td>" + vo.getName() + "회원님</td></tr>" + "<tr><td>결제수단  </td><td>"
				+ vo.getSelectpay() + "</td></tr>" + "<tr><td>좌석  </td><td>" + vo.getSitnum() + "번</td></tr>"
				+ "<tr><td>결제금액 </td><td>" + vo.getPay() + "원</td></tr>" + "<tr><td> </td><td></td></tr>"
				+ "<tr><td colspan='2'>자세한 운행경로와 경유시간 등은 홈페이지에서 확인해주세요.</td><td></td></tr>" + "</table>";
		if (email != null) {
			mailService.send(title, content, "WhatTheBus1@gmail.com", email);
		}

		return "booking/successPay";
	}

	@RequestMapping("/view/**/getBookingPayList.do")
	public String getBookingPayList(BookingPayVO bookingPayVO, ReviewVO reviewVO, Model model, HttpSession session,
			@RequestParam(defaultValue = "1") int curPage) {

		MemberVO vo = (MemberVO) session.getAttribute("member");
		String id = vo.getId();
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

		Map<String, Object> map = new HashMap<String, Object>();
		map.put("reviewCount", reviewCount);
		map.put("list", list);
		map.put("count", listCnt);
		map.put("pagination", pagination);
		model.addAttribute("map", map);

		return "member/member_getBookingPayList";
	}

	@RequestMapping("/view/**/getDriverBookingPayList.do")
	public String getDriverBookingPayList(BookingPayVO bookingPayVO, ReviewVO reviewVO, Model model,
			HttpSession session, @RequestParam(defaultValue = "1") int curPage) {

		DriverVO vo = (DriverVO) session.getAttribute("member");
		String id = vo.getId();
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

		Map<String, Object> map = new HashMap<String, Object>();
		map.put("reviewCount", reviewCount);
		map.put("list", list);
		map.put("count", listCnt);
		map.put("pagination", pagination);
		model.addAttribute("map", map);

		return "driver/driver_getBookingPayList";
	}

}
