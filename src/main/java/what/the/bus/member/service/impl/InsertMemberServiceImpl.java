package what.the.bus.member.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import what.the.bus.member.MemberVO;
import what.the.bus.member.dao.impl.MemberDAOImpl;
import what.the.bus.member.service.InsertMemberService;

@Service
public class InsertMemberServiceImpl implements InsertMemberService {
	@Autowired
	private MemberDAOImpl memberDAO;

	@Override
	public void insertMember(MemberVO vo) {
		memberDAO.insertMember(vo);
	}
}
