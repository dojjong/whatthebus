package what.the.bus.driver.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import what.the.bus.driver.DriverVO;
import what.the.bus.driver.dao.impl.DriverDAOImpl;
import what.the.bus.driver.service.InsertDriverService;
import what.the.bus.util.BCrypt;
import what.the.bus.util.SHA256;
@Service
public class InsertDriverServiceImpl implements InsertDriverService{
	@Autowired
	private DriverDAOImpl driverDAO;
	private SHA256 sha = SHA256.getInsatnce();

	@Override
	public void insertDriver(DriverVO vo) {
		// 암호화 변경 코드
		try {
			String shaPass = sha.getSha256(vo.getPassword().getBytes());
			String bcPass = BCrypt.hashpw(shaPass, BCrypt.gensalt());
			vo.setPassword(bcPass);
			driverDAO.insertDriver(vo);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
}
