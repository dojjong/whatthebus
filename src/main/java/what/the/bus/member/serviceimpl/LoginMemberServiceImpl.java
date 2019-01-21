package what.the.bus.member.serviceimpl;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.SessionAttributes;

import what.the.bus.member.MemberVO;
import what.the.bus.member.impl.MemberDAO;
import what.the.bus.member.service.LoginMemberService;

@Service
public class LoginMemberServiceImpl implements LoginMemberService {

	@Autowired
	private MemberDAO memberDAO;

	@Override
	public boolean loginMember(MemberVO vo) {
		if (vo.getPassword().equals(memberDAO.loginMember(vo).getPassword())) {
			return true;
		} else {
			return false;
		}
	}

}
