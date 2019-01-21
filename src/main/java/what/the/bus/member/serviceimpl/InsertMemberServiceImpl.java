package what.the.bus.member.serviceimpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import what.the.bus.member.MemberVO;
import what.the.bus.member.impl.MemberDAO;
import what.the.bus.member.service.InsertMemberService;

@Service
public class InsertMemberServiceImpl implements InsertMemberService {
	@Autowired
	private MemberDAO memberDAO;

	@Override
	public void insertMember(MemberVO vo) {
		memberDAO.insertMember(vo);
	}
}
