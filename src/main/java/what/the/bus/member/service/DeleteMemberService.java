package what.the.bus.member.service;

import what.the.bus.member.MemberVO;

public interface DeleteMemberService {
	void deleteMember(MemberVO vo);
	
	MemberVO getMember(MemberVO vo);
	
	boolean pwCheckMember(MemberVO vo);
}
