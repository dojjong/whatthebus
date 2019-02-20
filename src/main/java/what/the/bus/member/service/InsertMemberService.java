package what.the.bus.member.service;

import what.the.bus.member.MemberVO;

public interface InsertMemberService {
	void insertMember(MemberVO vo);

	void insertKakaoMember(MemberVO vo);

	void insertNaverMember(MemberVO vo);
	
	int checkMember(String checkMember);

	String checkEmail(String checkEmail);

}
