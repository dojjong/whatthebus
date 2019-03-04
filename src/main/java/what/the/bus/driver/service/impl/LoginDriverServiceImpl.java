package what.the.bus.driver.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import what.the.bus.driver.DriverVO;
import what.the.bus.driver.dao.DriverDAO;
import what.the.bus.driver.service.LoginDriverService;
import what.the.bus.util.BCrypt;
import what.the.bus.util.SHA256;

@Service
public class LoginDriverServiceImpl implements LoginDriverService {

	@Autowired
	private DriverDAO driverDAO;
	private SHA256 sha = SHA256.getInsatnce();

	@Override
	public boolean loginDriver(DriverVO vo) {
		// 암호화된 비번 디비랑 비교하는 코드
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

}
