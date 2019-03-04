package what.the.bus.lostBoard.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import what.the.bus.lostBoard.LostBoardVO;
import what.the.bus.lostBoard.dao.LostBoardDAO;
import what.the.bus.lostBoard.service.DeleteLostBoardService;

@Service
public class DeleteLostBoardServiceImpl implements DeleteLostBoardService {

	@Autowired
	private LostBoardDAO lostBoardDAO;
	
	@Override
	public void deleteLostBoard(LostBoardVO vo) {
		lostBoardDAO.deleteLostBoard(vo);
	}
	
	@Override
	public LostBoardVO getLostBoard(int seq) {
		return lostBoardDAO.getLostBoard(seq);
	}
	
	@Override
	public void deleteLostComment(LostBoardVO vo) {
		lostBoardDAO.deleteLostBoard(vo);
	}

	
	
}
