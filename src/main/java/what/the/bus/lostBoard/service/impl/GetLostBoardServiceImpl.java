package what.the.bus.lostBoard.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import what.the.bus.lostBoard.LostBoardVO;
import what.the.bus.lostBoard.impl.LostBoardDAOImpl;
import what.the.bus.lostBoard.service.GetLostBoardService;

@Service
public class GetLostBoardServiceImpl implements GetLostBoardService {

	@Autowired
	private LostBoardDAOImpl lostBoardDAO;
	
	@Override
	public LostBoardVO getLostBoard(int seq) {
		return lostBoardDAO.getLostBoard(seq);
	}

}
