package what.the.bus.booking.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import what.the.bus.booking.BookingPayVO;
import what.the.bus.booking.dao.impl.BookingPayDAOImpl;
import what.the.bus.booking.service.BookingPayService;
import what.the.bus.member.MemberVO;

@Service
public class BookingPayServiceImpl implements BookingPayService {
	@Autowired
	private BookingPayDAOImpl bookingPayDAO;

	@Override
	public void insertBookingPay(BookingPayVO vo) {
		bookingPayDAO.insertBookingPay(vo);
	}

	@Override
	public List<Integer> getSitNumList(int busseq) {
		return bookingPayDAO.getSitNumList(busseq);
	}


	@Override
	public List<BookingPayVO> getBookingPayList(int start, int end, String id) {
		return bookingPayDAO.getBookingPayList(start, end, id);
	}

	@Override
	public int getBookingPayListCount(BookingPayVO vo) {
		return bookingPayDAO.getBookingPayListCount(vo);
	}



}
