package what.the.bus.lostBoard.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import what.the.bus.lostBoard.LostBoardVO;
import what.the.bus.lostBoard.impl.LostBoardDAOImpl;
import what.the.bus.lostBoard.service.GetLostBoardListService;

@Service
public class GetLostBoardListServiceImpl implements GetLostBoardListService {

	@Autowired
	private LostBoardDAOImpl lostBoardDAO;
	
	public void setLostBoardDAO(LostBoardDAOImpl lostBoardDAO) {
		this.lostBoardDAO = lostBoardDAO;
	}
	
	@Override
	public List<LostBoardVO> getLostBoardList() {
		return lostBoardDAO.getLostBoardList();
	}

	@Override
	public Integer getLostBoardLostCount(LostBoardVO vo) {
		return lostBoardDAO.getLostBoardListCount();
	}
	
	

}
