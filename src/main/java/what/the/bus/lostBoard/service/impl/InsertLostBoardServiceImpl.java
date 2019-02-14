package what.the.bus.lostBoard.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import what.the.bus.lostBoard.LostBoardVO;
import what.the.bus.lostBoard.impl.LostBoardDAOImpl;
import what.the.bus.lostBoard.service.InsertLostBoardService;

@Service
public class InsertLostBoardServiceImpl implements InsertLostBoardService {

	@Autowired
	private LostBoardDAOImpl lostboardDAO;

	@Override
	public void insertLostBoard(LostBoardVO vo) {
		lostboardDAO.insertLostBoard(vo);
	}

}
