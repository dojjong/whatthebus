package what.the.bus.best.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import what.the.bus.best.BestVO;
import what.the.bus.best.dao.BestDAO;
import what.the.bus.best.service.BestService;

@Service
public class BestServiceImpl implements BestService {

	@Autowired
	private BestDAO bestDAO;

	@Override
	public void best_check(BestVO vo) {
		bestDAO.best_check(vo);
	}

	@Override
	public void best_cancel(BestVO vo) {
		bestDAO.best_cancel(vo);
	}

	@Override
	public BestVO getBest(BestVO vo) {
		return bestDAO.getBest(vo);
	}

	@Override
	public void boardOnBestUpdate(BestVO vo) {
		bestDAO.boardOnBestUpdate(vo);
	}

	@Override
	public void boardOffBestUpdate(BestVO vo) {
		bestDAO.boardOffBestUpdate(vo);
	}

	@Override
	public int getBoardBest(int seq) {
		return bestDAO.getBoardBest(seq);
	}

	@Override
	public int getCheckBest(BestVO vo) {
		return bestDAO.getCheckBest(vo);
	}

	@Override
	public void insertBest(BestVO vo) {
		bestDAO.insertBest(vo);
	}

	

}
