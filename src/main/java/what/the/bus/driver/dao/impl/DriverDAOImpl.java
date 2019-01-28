package what.the.bus.driver.dao.impl;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

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
		mybatis.delete("DriverDAO.deleteDriver", vo);
	}

	public DriverVO loginDriver(DriverVO vo) {
		return mybatis.selectOne("DriverDAO.loginDriver", vo);
	}

	public void pwUpdateDriver(DriverVO vo) {
		mybatis.update("DriverDAO.pwUpdateDriver", vo);
	}
	
}
