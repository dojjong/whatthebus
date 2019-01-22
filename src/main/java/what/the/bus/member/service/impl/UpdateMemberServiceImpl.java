package what.the.bus.member.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import what.the.bus.member.MemberVO;
import what.the.bus.member.dao.impl.MemberDAOImpl;
import what.the.bus.member.service.UpdateMemberService;
@Service
public class UpdateMemberServiceImpl implements UpdateMemberService {
	@Autowired
	private MemberDAOImpl memberDAO;

	@Override
	public void updateMember(MemberVO vo) {
		memberDAO.updateMember(vo);
	}

}
