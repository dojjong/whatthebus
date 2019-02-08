package what.the.bus.best.service;

import what.the.bus.best.BestVO;

public interface BestService {
	void best_check(BestVO vo);

	void best_cancel(BestVO vo);

	BestVO getBest(BestVO vo);

	void boardOnBestUpdate(BestVO vo);

	void boardOffBestUpdate(BestVO vo);

	int getBoardBest(int seq);

	int getCheckBest(BestVO vo);

	void insertBest(BestVO vo);
	

}
