package what.the.bus.member.service;

import java.util.List;

import what.the.bus.board.BoardVO;
import what.the.bus.board.ChartVO1;
import what.the.bus.member.MemberVO;

public interface LoginMemberService {
	boolean loginMember(MemberVO vo);

	MemberVO getMember(MemberVO vo);

	List<ChartVO1> getMemberCountPerRegdateJson();

	List<BoardVO> getMyWriteList(int start, int end, String id);

	int getMyWriteListCount(String id);
}
