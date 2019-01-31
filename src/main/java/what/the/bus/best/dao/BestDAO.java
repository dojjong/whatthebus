package what.the.bus.best.dao;

import what.the.bus.best.BestVO;
import what.the.bus.board.BoardVO;

public interface BestDAO {
	void best_check(BestVO vo);

	void best_cancel(BestVO vo);

	BestVO getBest(BestVO vo);

	void boardOnBestUpdate(BestVO vo);

	void boardOffBestUpdate(BestVO vo);
	
	int getBoardBest(int seq);

}
