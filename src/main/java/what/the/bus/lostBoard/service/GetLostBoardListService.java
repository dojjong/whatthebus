package what.the.bus.lostBoard.service;

import java.util.List;

import what.the.bus.lostBoard.LostBoardVO;

public interface GetLostBoardListService {

	List<LostBoardVO>  getLostBoardList();
	
	Integer getLostBoardLostCount(LostBoardVO vo);
}
