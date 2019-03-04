package what.the.bus.driver.service;

import java.util.List;

import what.the.bus.booking.BookingPayVO;
import what.the.bus.driver.DriverVO;

public interface UpdateDriverService {
	void updateDriver(DriverVO vo);

	DriverVO getDriver(DriverVO vo);

	boolean pwCheckDriver(DriverVO vo);

	void pwUpdateDriver(DriverVO vo);

	List<BookingPayVO> getDriverPointList(int start, int end, String id);

	int getDriverPointListCount(String id);
}
