package what.the.bus.booking.dao.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import what.the.bus.admin.ChartVO1;
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
	public List<BookingPayVO> getBookingPayList(int start, int end, String id) {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("start", start);
		map.put("end", end);
		map.put("id", id);
		return mybatis.selectList("BookingPayDAO.getBookingPayList", map);
	}

	@Override
	public int getBookingPayListCount(BookingPayVO vo) {
		return mybatis.selectOne("BookingPayDAO.getBookingPayListCount", vo);
	}

	@Override
	public void useMemberPoint(BookingPayVO vo) {
		mybatis.update("BookingPayDAO.useMemberPoint", vo);
	}

	@Override
	public void useDriverPoint(BookingPayVO vo) {
		mybatis.update("BookingPayDAO.useDriverPoint", vo);
	}

	@Override
	public int getMemberPoint(String id) {
		return mybatis.selectOne("BookingPayDAO.getMemberPoint", id);
	}

	@Override
	public int getDriverPoint(String id) {
		return mybatis.selectOne("BookingPayDAO.getDriverPoint", id);
	}
	

	@Override
	public List<ChartVO1> getPayPerRegdate(BookingPayVO vo) {
		return mybatis.selectList("BookingPayDAO.getPayPerRegdate", vo);
	}
	
	

}
