package what.the.bus.booking.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import what.the.bus.admin.ChartVO1;
import what.the.bus.booking.BookingPayVO;
import what.the.bus.booking.dao.BookingPayDAO;
import what.the.bus.booking.service.BookingPayService;

@Service
public class BookingPayServiceImpl implements BookingPayService {
	@Autowired
	private BookingPayDAO bookingPayDAO;

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

	@Override
	public List<ChartVO1> getPayPerRegdate(BookingPayVO vo) {
		return bookingPayDAO.getPayPerRegdate(vo);
	}

	@Override
	public void useMemberPoint(BookingPayVO vo) {
		int imsi1 = getMemberPoint(vo.getId());
		int imsi2 = (vo.getPay() - vo.getPoint()) / 10;
		int point = (imsi1 - vo.getPoint()) + imsi2;
		vo.setPoint(point);
		bookingPayDAO.useMemberPoint(vo);
	}

	@Override
	public void useDriverPoint(BookingPayVO vo) {
		int imsi1 = getDriverPoint(vo.getId());
		int imsi2 = (vo.getPay() - vo.getPoint()) / 10;
		int point = (imsi1 - vo.getPoint()) + imsi2;
		vo.setPoint(point);

		bookingPayDAO.useDriverPoint(vo);

	}

	@Override
	public int getMemberPoint(String id) {
		return bookingPayDAO.getMemberPoint(id);
	}

	@Override
	public int getDriverPoint(String id) {
		return bookingPayDAO.getDriverPoint(id);
	}

}