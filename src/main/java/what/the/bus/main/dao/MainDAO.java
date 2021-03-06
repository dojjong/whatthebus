package what.the.bus.main.dao;

import java.util.List;

import what.the.bus.board.BoardVO;
import what.the.bus.member.MemberVO;
import what.the.bus.noticeBoard.NoticeBoardVO;
import what.the.bus.suggestBoard.SuggestBoardVO;

public interface MainDAO {
	int getIdCheck(MemberVO vo);

	String getId(MemberVO vo);

	int getPWCheck(MemberVO vo);

	int idCheckMember(MemberVO vo);

	int idCheckDriver(MemberVO vo);

	void updatePWMember(MemberVO vo);

	void updatePWDriver(MemberVO vo);

	List<BoardVO> hotList(int maincount);

	List<BoardVO> recentList(int maincount);

	List<SuggestBoardVO> finishTimeList(int maincount);

	List<NoticeBoardVO> noticeList(int maincount);

	int getMainCount();
}
