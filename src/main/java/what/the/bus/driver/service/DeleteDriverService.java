package what.the.bus.driver.service;

import what.the.bus.driver.DriverVO;

public interface DeleteDriverService {
	void deleteDriver(DriverVO vo);

	DriverVO getDriver(DriverVO vo);

	boolean pwCheckDriver(DriverVO vo);
}
