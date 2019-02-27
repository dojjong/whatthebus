package what.the.bus.member.dao;

import java.util.List;

import what.the.bus.board.ChartVO1;
import what.the.bus.member.MemberVO;

public interface MemberDAO {
	void insertMember(MemberVO vo);

	void insertKakaoMember(MemberVO vo);
	
	void insertNaverMember(MemberVO vo);

	void updateMember(MemberVO vo);

	void deleteMember(MemberVO vo);

	MemberVO loginMember(MemberVO vo);

	void pwUpdateMember(MemberVO vo);

	int checkMember(String checkMember);

	String checkEmail(String checkEmail);

	String checkName(String checkName); // 01.31

	List<ChartVO1> getMemberCountPerRegdateJson();
	
}
