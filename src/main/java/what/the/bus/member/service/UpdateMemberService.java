package what.the.bus.member.service;

import what.the.bus.member.MemberVO;

public interface UpdateMemberService {
	void updateMember(MemberVO vo);
	MemberVO getMember(MemberVO vo);
	boolean pwCheckMember(MemberVO vo);
}
