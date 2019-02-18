package what.the.bus.eventBoard.service;

import what.the.bus.eventBoard.EventBoardVO;

public interface UpdateEventBoardService {
	EventBoardVO getEventBoard(int seq);
	void updateEventBoard(EventBoardVO vo);
}
