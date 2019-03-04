package what.the.bus.booking.dao;

import java.util.List;

import what.the.bus.booking.BookingPayVO;
import what.the.bus.member.MemberVO;

public interface BookingPayDAO {
	void insertBookingPay(BookingPayVO vo);

	List<Integer> getSitNumList(int busseq);

	List<BookingPayVO> getBookingPayList(int start, int end, String id);

	int getBookingPayListCount(BookingPayVO vo);

	void useMemberPoint(BookingPayVO vo);

	void useDriverPoint(BookingPayVO vo);

	int getMemberPoint(String id);

	int getDriverPoint(String id);
}
