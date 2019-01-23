package what.the.bus.driver.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import what.the.bus.driver.DriverVO;
import what.the.bus.driver.dao.impl.DriverDAOImpl;
import what.the.bus.driver.service.DeleteDriverService;
@Service
public class DeleteDriverServiceImpl implements DeleteDriverService {

	@Autowired
	private DriverDAOImpl driverDAO;

	@Override
	public void deleteDriver(DriverVO vo) {
		driverDAO.deleteDriver(vo);
	}

}
