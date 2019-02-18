package what.the.bus.lostBoard.service;

import what.the.bus.lostBoard.LostBoardVO;

public interface DeleteLostBoardService {
	
	void deleteLostBoard(LostBoardVO vo);
	
	LostBoardVO getLostBoard(int seq);
	
	void deleteLostComment(LostBoardVO vo);

}
