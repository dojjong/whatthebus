package what.the.bus.driver.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import what.the.bus.booking.BookingPayVO;
import what.the.bus.driver.DriverVO;
import what.the.bus.driver.dao.impl.DriverDAOImpl;
import what.the.bus.driver.service.UpdateDriverService;
import what.the.bus.util.BCrypt;
import what.the.bus.util.SHA256;

@Service
public class UpdateDriverServiceImpl implements UpdateDriverService {

	@Autowired
	private DriverDAOImpl driverDAO;
	private SHA256 sha = SHA256.getInsatnce();

	@Override
	public void updateDriver(DriverVO vo) {
		driverDAO.updateDriver(vo);
	}

	@Override
	public boolean pwCheckDriver(DriverVO vo) {
		// 암호화 비교
		try {
			String shaPass = sha.getSha256(vo.getPassword().getBytes());
			if (BCrypt.checkpw(shaPass, getDriver(vo).getPassword())) {
				return true;
			} else {
				return false;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public DriverVO getDriver(DriverVO vo) {
		return driverDAO.loginDriver(vo);
	}

	@Override
	public void pwUpdateDriver(DriverVO vo) {
		// 다시 암호화해서 비번변경
		try {
			String shaPass = sha.getSha256(vo.getPassword().getBytes());
			String bcPass = BCrypt.hashpw(shaPass, BCrypt.gensalt());
			vo.setPassword(bcPass);
			driverDAO.pwUpdateDriver(vo);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public List<BookingPayVO> getDriverPointList(int start, int end, String id) {
		return driverDAO.getDriverPointList(start, end, id);
	}

	@Override
	public int getDriverPointListCount(String id) {
		return driverDAO.getDriverPointListCount(id);
	}

}
