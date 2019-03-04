package what.the.bus.driver.dao;

import java.util.List;

import what.the.bus.booking.BookingPayVO;
import what.the.bus.driver.DriverVO;

public interface DriverDAO {
	void insertDriver(DriverVO vo);

	void updateDriver(DriverVO vo);

	void deleteDriver(DriverVO vo);

	DriverVO loginDriver(DriverVO vo);

	void pwUpdateDriver(DriverVO vo);

	List<BookingPayVO> getDriverPointList(int start, int end, String id);

	int getDriverPointListCount(String id);
}
