package what.the.bus.booking.service;

import java.util.List;

import what.the.bus.booking.BookingPayVO;
import what.the.bus.member.MemberVO;

public interface BookingPayService {
	void insertBookingPay(BookingPayVO vo);

	List<Integer> getSitNumList(int busseq);
	
	List<BookingPayVO> getBookingPayList(int start, int end, String id);

	int getBookingPayListCount(BookingPayVO vo);

}
