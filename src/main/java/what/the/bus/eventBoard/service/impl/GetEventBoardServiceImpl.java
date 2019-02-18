package what.the.bus.eventBoard.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import what.the.bus.eventBoard.EventBoardVO;
import what.the.bus.eventBoard.dao.EventBoardDAO;
import what.the.bus.eventBoard.service.GetEventBoardService;

@Service
public class GetEventBoardServiceImpl implements GetEventBoardService{
	
	@Autowired
	private EventBoardDAO eventboardDAO;

	@Override
	public EventBoardVO getEventBoard(int seq) {
		return eventboardDAO.getEventBoard(seq);
	}
	
	

}
