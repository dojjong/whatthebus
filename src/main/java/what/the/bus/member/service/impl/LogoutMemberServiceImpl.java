package what.the.bus.member.service.impl;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Service;

import what.the.bus.member.service.LogoutMemberService;

@Service
public class LogoutMemberServiceImpl implements LogoutMemberService {

	@Override
	public void logoutMember(HttpSession session) {
		session.invalidate();
	}

}
