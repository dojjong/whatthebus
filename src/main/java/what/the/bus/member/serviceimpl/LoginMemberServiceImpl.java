package what.the.bus.member.serviceimpl;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import what.the.bus.member.MemberVO;
import what.the.bus.member.impl.MemberDAO;
import what.the.bus.member.service.LoginMemberService;

@Service
public class LoginMemberServiceImpl implements LoginMemberService {

	@Autowired
	private MemberDAO memberDAO;

	@Override
	public boolean loginMember(MemberVO vo) {
		memberDAO.loginMember(vo);
		if (vo.getPassword().equals(memberDAO.loginMember(vo).getPassword())) {
			return true;
		} else {
			return false;
		}
	}

}
