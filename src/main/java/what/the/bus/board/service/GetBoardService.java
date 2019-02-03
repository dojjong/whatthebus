package what.the.bus.board.service;

import what.the.bus.best.BestVO;
import what.the.bus.board.BoardVO;

public interface GetBoardService {
	BoardVO getBoard(int seq);

	int getCheckBest(BestVO vo);
	
	int getCheckBestCheck(BestVO vo);
}
