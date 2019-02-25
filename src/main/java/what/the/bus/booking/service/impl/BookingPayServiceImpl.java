package what.the.bus.booking.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import what.the.bus.booking.BookingPayVO;
import what.the.bus.booking.dao.impl.BookingPayDAOImpl;
import what.the.bus.booking.service.BookingPayService;

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
	public List<BookingPayVO> getBookingPayList(String id) {
		return bookingPayDAO.getBookingPayList(id);
	}

}
