package what.the.bus.lostBoard.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import what.the.bus.lostBoard.LostBoardVO;
import what.the.bus.lostBoard.dao.LostBoardDAO;
import what.the.bus.lostBoard.service.UpdateLostBoardService;

@Service
public class UpdateLostBoardServiceImpl implements UpdateLostBoardService {

	@Autowired
	private LostBoardDAO lostBoardDAO;
	
	@Override
	public void updateLostBoard(LostBoardVO vo) {
		lostBoardDAO.updateLostBoard(vo);
	}
	
	@Override
	public LostBoardVO getLostBoard(int seq) {
		return lostBoardDAO.getLostBoard(seq);
	}

}
