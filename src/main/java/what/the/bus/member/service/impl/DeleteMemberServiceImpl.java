package what.the.bus.member.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import what.the.bus.member.MemberVO;
import what.the.bus.member.dao.impl.MemberDAOImpl;
import what.the.bus.member.service.DeleteMemberService;
@Service
public class DeleteMemberServiceImpl implements DeleteMemberService {

	@Autowired
	private MemberDAOImpl memberDAO;

	@Override
	public void deleteMember(MemberVO vo) {
		memberDAO.deleteMember(vo);
	}

}
