package what.the.bus.booking.dao.impl;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import what.the.bus.booking.BookingPayVO;
import what.the.bus.booking.dao.BookingPayDAO;
import what.the.bus.util.SqlSessionFactoryBean;

@Repository
public class BookingPayDAOImpl implements BookingPayDAO {
	@Autowired
	private SqlSession mybatis;

	public BookingPayDAOImpl() {
		mybatis = SqlSessionFactoryBean.getSqlSessionInstance();
	}

	@Override
	public void insertBookingPay(BookingPayVO vo) {
		mybatis.insert("BookingPayDAO.insertBookingPay", vo);
	}

	@Override
	public List<Integer> getSitNumList(int busseq) {
		return mybatis.selectList("BookingPayDAO.getSitNumList", busseq);
	}

	@Override
	public List<BookingPayVO> getBookingPayList(String id) {
		return mybatis.selectList("BookingPayDAO.getBookingPayList", id);
	}


}
