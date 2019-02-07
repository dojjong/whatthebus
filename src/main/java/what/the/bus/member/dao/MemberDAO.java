package what.the.bus.member.dao;

import what.the.bus.member.MemberVO;

public interface MemberDAO {
	void insertMember(MemberVO vo);

	void updateMember(MemberVO vo);

	void deleteMember(MemberVO vo);

	MemberVO loginMember(MemberVO vo);

	void pwUpdateMember(MemberVO vo);

	int checkMember(String checkMember);
	
	String checkEmail(String checkEmail);
	
	String checkName(String checkName); //01.31
	
	String findId(MemberVO vo); //02.06
	

}
