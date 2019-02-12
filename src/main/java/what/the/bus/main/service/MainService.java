package what.the.bus.main.service;

import what.the.bus.member.MemberVO;

public interface MainService {
	String getId(MemberVO vo);

	int getIdCheck(MemberVO vo);

	int getPWCheck(MemberVO vo);

	int idCheckMember(MemberVO vo);

	int idCheckDriver(MemberVO vo);

	void updatePWMember(MemberVO vo);

	void updatePWDriver(MemberVO vo);
}
