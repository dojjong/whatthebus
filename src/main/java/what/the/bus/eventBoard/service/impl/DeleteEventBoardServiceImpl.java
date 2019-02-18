package what.the.bus.eventBoard.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import what.the.bus.eventBoard.EventBoardVO;
import what.the.bus.eventBoard.dao.EventBoardDAO;
import what.the.bus.eventBoard.service.DeleteEventBoardService;

@Service
public class DeleteEventBoardServiceImpl implements DeleteEventBoardService{

	@Autowired
	private EventBoardDAO eventboardDAO;

	@Override
	public void deleteEvnetBoard(EventBoardVO vo) {
		eventboardDAO.deleteEventBoard(vo);
		
	}

	@Override
	public EventBoardVO getEvnetBoard(int seq) {
		return eventboardDAO.getEventBoard(seq);
	}

	@Override
	public void deleteEventComment(EventBoardVO vo) {
		eventboardDAO.deleteEventComment(vo);
	}
	
	
	
}
