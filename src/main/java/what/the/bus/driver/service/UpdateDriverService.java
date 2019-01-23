package what.the.bus.driver.service;

import what.the.bus.driver.DriverVO;

public interface UpdateDriverService {
	void updateDriver(DriverVO vo);
	DriverVO getDriver(DriverVO vo);
	boolean pwCheckDriver(DriverVO vo);
	void pwUpdateDriver(DriverVO vo);
}
