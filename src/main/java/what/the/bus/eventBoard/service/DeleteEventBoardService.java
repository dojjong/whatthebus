package what.the.bus.eventBoard.service;

import what.the.bus.eventBoard.EventBoardVO;

public interface DeleteEventBoardService {
	void deleteEvnetBoard(EventBoardVO vo);
	EventBoardVO getEvnetBoard(int seq);
	void deleteEventComment(EventBoardVO vo);
}
