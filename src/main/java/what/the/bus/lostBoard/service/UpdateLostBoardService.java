package what.the.bus.lostBoard.service;

import what.the.bus.lostBoard.LostBoardVO;

public interface UpdateLostBoardService {
	LostBoardVO getLostBoard(int seq);
	void updateLostBoard(LostBoardVO vo);
}
