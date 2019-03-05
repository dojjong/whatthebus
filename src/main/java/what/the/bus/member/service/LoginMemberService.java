package what.the.bus.member.service;

import java.util.List;

import what.the.bus.admin.ChartVO1;
import what.the.bus.board.BoardVO;
import what.the.bus.member.MemberVO;
import what.the.bus.suggestBoard.SuggestBoardVO;

public interface LoginMemberService {
	boolean loginMember(MemberVO vo);

	MemberVO getMember(MemberVO vo);



	List<BoardVO> getMyWriteList(int start, int end, String id);

	int getMyWriteListCount(String id);

	List<SuggestBoardVO> getMyDriveList(int start, int end, String id);

	int getMyDriveListCount(String id);
	
	List<ChartVO1> getMemberCountPerRegdateJson(MemberVO vo);
}
