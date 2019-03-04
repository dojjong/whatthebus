package what.the.bus.main.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import what.the.bus.main.dao.MainDAO;
import what.the.bus.main.service.MainService;
import what.the.bus.member.MemberVO;
import what.the.bus.util.BCrypt;
import what.the.bus.util.SHA256;

@Service
public class MainServiceImpl implements MainService {
	@Autowired
	private MainDAO mainDAO;
	private SHA256 sha = SHA256.getInsatnce();

	@Override
	public String getId(MemberVO vo) {
		return mainDAO.getId(vo);
	}

	@Override
	public int getIdCheck(MemberVO vo) {
		return mainDAO.getIdCheck(vo);
	}

	@Override
	public int getPWCheck(MemberVO vo) {
		return mainDAO.getPWCheck(vo);
	}

	@Override
	public int idCheckMember(MemberVO vo) {
		return mainDAO.idCheckMember(vo);
	}

	@Override
	public int idCheckDriver(MemberVO vo) {
		return mainDAO.idCheckDriver(vo);
	}

	@Override
	// 회원 비밀번호 변경
	public void updatePWMember(MemberVO vo) {
		try {
			String shaPass = sha.getSha256(vo.getPassword().getBytes());
			String bcPass = BCrypt.hashpw(shaPass, BCrypt.gensalt());
			vo.setPassword(bcPass);
			mainDAO.updatePWMember(vo);
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	@Override
	public void updatePWDriver(MemberVO vo) {
		try {
			String shaPass = sha.getSha256(vo.getPassword().getBytes());
			String bcPass = BCrypt.hashpw(shaPass, BCrypt.gensalt());
			vo.setPassword(bcPass);
			mainDAO.updatePWDriver(vo);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
