package what.the.bus.booking.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import what.the.bus.bookBoard.service.GetBookBoardService;
import what.the.bus.booking.BookingPayVO;
import what.the.bus.booking.service.BookingPayService;
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
	public String bookingPay(BookingPayVO vo) {
		bookingPayService.insertBookingPay(vo);
		return "booking/successPay";
	}
	
}