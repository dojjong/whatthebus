package what.the.bus.driver.service.impl;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import what.the.bus.driver.DriverVO;
import what.the.bus.driver.dao.impl.DriverDAOImpl;
import what.the.bus.driver.service.DeleteDriverService;
import what.the.bus.util.BCrypt;
import what.the.bus.util.SHA256;

@Service
public class DeleteDriverServiceImpl implements DeleteDriverService {

	@Autowired
	private DriverDAOImpl driverDAO;
	private SHA256 sha = SHA256.getInsatnce();

	@Override
	public void deleteDriver(DriverVO vo) {
		driverDAO.deleteDriver(vo);
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


}
