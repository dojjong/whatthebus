package what.the.bus.booking.service;

import java.util.List;

import what.the.bus.booking.BookingPayVO;

public interface BookingPayService {
	void insertBookingPay(BookingPayVO vo);

	List<Integer> getSitNumList(int busseq);
	
	List<BookingPayVO> getBookingPayList(String id);

}
