package what.the.bus.member.serviceimpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import what.the.bus.member.MemberVO;
import what.the.bus.member.impl.MemberDAO;
import what.the.bus.member.service.UpdateMemberService;
@Service
public class UpdateMemberServiceImpl implements UpdateMemberService {
	@Autowired
	private MemberDAO memberDAO;

	@Override
	public void updateMember(MemberVO vo) {
		memberDAO.updateMember(vo);
	}

}
