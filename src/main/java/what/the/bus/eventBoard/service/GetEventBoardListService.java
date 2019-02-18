package what.the.bus.eventBoard.service;

import java.util.List;

import what.the.bus.eventBoard.EventBoardVO;
import what.the.bus.eventComment.EventCommentVO;

public interface GetEventBoardListService {

	List<EventBoardVO> getEventBoardList(int start, int end, String searchOption, String keyword);

	Integer getEventBoardListCount(EventBoardVO vo);

	Integer getEventBoardCommentContentListCount(EventCommentVO vo);

	Integer getEventBoardCommentNameListCount(EventCommentVO vo);

	Integer getEventCommentCount(int seq);
	
}
