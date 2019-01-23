package what.the.bus.driver.service;

import what.the.bus.driver.DriverVO;

public interface LoginDriverService {
	boolean loginDriver(DriverVO vo);

	DriverVO getDriver(DriverVO vo);
}
