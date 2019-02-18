package what.the.bus.eventBoard.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import what.the.bus.eventBoard.EventBoardVO;
import what.the.bus.eventBoard.dao.EventBoardDAO;
import what.the.bus.eventBoard.service.UpdateEventBoardService;
@Service
public class UpdateEventBoardServiceImpl implements UpdateEventBoardService{
	@Autowired
	private EventBoardDAO eventboatdDAO;
	
	
	@Override
	public EventBoardVO getEventBoard(int seq) {
		return eventboatdDAO.getEventBoard(seq);
	}

	@Override
	public void updateEventBoard(EventBoardVO vo) {
		eventboatdDAO.updateEventBoard(vo);
	}

}
