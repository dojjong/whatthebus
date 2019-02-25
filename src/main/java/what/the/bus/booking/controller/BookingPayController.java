package what.the.bus.booking.controller;

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
import what.the.bus.suggestBoard.SuggestBoardVO;

@Controller
public class BookingPayController {
	@Autowired
	private GetBookBoardService bookBoardService;
	@Autowired
	private BookingPayService bookingPayService;
	
	@RequestMapping("/view/**/bookingTicket.do")
	public String bookingTicket(Integer seq, Model model) {
		SuggestBoardVO vo = bookBoardService.getBookBoard(seq);
		List<Integer> busSit = bookingPayService.getSitNumList(seq);
						
		model.addAttribute("bussit",busSit);
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
	public String getBookingPayList(BookingPayVO bookingPayVO, Model model, HttpSession session,@RequestParam(defaultValue = "1") int curPage) {

		//int listCnt = 0;
		//listCnt =  bookingPayService.getBookingPayListCount(bookingPayVO);
		Pagination pagination = new Pagination(curPage, curPage);
		

		int start = pagination.getPageBegin();
		int end = pagination.getPageEnd();
		
		String id;
		MemberVO vo;
		vo = (MemberVO)session.getAttribute("member");
		id = vo.getId();
		List<BookingPayVO> list = bookingPayService.getBookingPayList(start, end, id);
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("list", list);
		//map.put("count", listCnt);
		map.put("pagination", pagination);
		model.addAttribute("map", map);
		
		return "member/member_getBookingPayList";
	}
	
}
