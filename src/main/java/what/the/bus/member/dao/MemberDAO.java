package what.the.bus.member.dao;

import what.the.bus.member.MemberVO;

public interface MemberDAO {
	void insertMember(MemberVO vo);

	void updateMember(MemberVO vo);

	void deleteMember(MemberVO vo);

	MemberVO loginMember(MemberVO vo);

	void pwUpdateMember(MemberVO vo);
}
