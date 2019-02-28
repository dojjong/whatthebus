package what.the.bus.main.service;

import java.util.List;

import what.the.bus.board.BoardVO;
import what.the.bus.noticeBoard.NoticeBoardVO;
import what.the.bus.suggestBoard.SuggestBoardVO;

public interface MainListService {
	List<BoardVO> hotList(int maincount);

	List<BoardVO> recentList(int maincount);

	List<SuggestBoardVO> finishTimeList(int maincount);

	List<NoticeBoardVO> noticeList(int maincount);

	int getMainCount();
}
