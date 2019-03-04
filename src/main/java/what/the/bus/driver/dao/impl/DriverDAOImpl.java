package what.the.bus.driver.dao.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import what.the.bus.booking.BookingPayVO;
import what.the.bus.driver.DriverVO;
import what.the.bus.driver.dao.DriverDAO;
import what.the.bus.util.SqlSessionFactoryBean;

@Repository
public class DriverDAOImpl implements DriverDAO {

	@Autowired
	private SqlSession mybatis;

	public DriverDAOImpl() {
		mybatis = SqlSessionFactoryBean.getSqlSessionInstance();
	}

	public void insertDriver(DriverVO vo) {
		mybatis.insert("DriverDAO.insertDriver", vo);
	}

	public void updateDriver(DriverVO vo) {
		mybatis.update("DriverDAO.updateDriver", vo);
	}

	public void deleteDriver(DriverVO vo) {
		mybatis.update("DriverDAO.deleteDriver", vo);
	}

	public DriverVO loginDriver(DriverVO vo) {
		return mybatis.selectOne("DriverDAO.loginDriver", vo);
	}

	public void pwUpdateDriver(DriverVO vo) {
		mybatis.update("DriverDAO.pwUpdateDriver", vo);
	}

	@Override
	public List<BookingPayVO> getDriverPointList(int start, int end, String id) {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("id", id);
		map.put("start", start);
		map.put("end", end);
		return mybatis.selectList("DriverDAO.getDriverPointList", map);
	}

	@Override
	public int getDriverPointListCount(String id) {
		return mybatis.selectOne("DriverDAO.getDriverPointListCount", id);
	}

}
