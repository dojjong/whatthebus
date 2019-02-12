package what.the.bus.main.dao;

import what.the.bus.member.MemberVO;

public interface MainDAO {
	int getIdCheck(MemberVO vo);

	String getId(MemberVO vo);

	int getPWCheck(MemberVO vo);

	int idCheckMember(MemberVO vo);

	int idCheckDriver(MemberVO vo);

	void updatePWMember(MemberVO vo);

	void updatePWDriver(MemberVO vo);
}
