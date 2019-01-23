package what.the.bus.driver.dao;

import what.the.bus.driver.DriverVO;

public interface DriverDAO {
	void insertDriver(DriverVO vo);

	void updateDriver(DriverVO vo);

	void deleteDriver(DriverVO vo);

	DriverVO loginDriver(DriverVO vo);

	void pwUpdateDriver(DriverVO vo);
}
