package what.the.bus.booking.dao;

import java.util.List;

import what.the.bus.booking.BookingPayVO;

public interface BookingPayDAO {
	void insertBookingPay(BookingPayVO vo);

	List<Integer> getSitNumList(int busseq);
	
	
	
}
