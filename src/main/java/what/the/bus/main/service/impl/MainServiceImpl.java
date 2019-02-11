package what.the.bus.main.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import what.the.bus.main.dao.impl.MainDAOImpl;
import what.the.bus.main.service.MainService;
import what.the.bus.member.MemberVO;

@Service
public class MainServiceImpl implements MainService {
	@Autowired
	private MainDAOImpl mainDAO;

	@Override
	public String getId(MemberVO vo) {
		return mainDAO.getId(vo);
	}

	@Override
	public int getIdCheck(MemberVO vo) {
		return mainDAO.getIdCheck(vo);
	}

}
