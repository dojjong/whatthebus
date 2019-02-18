package what.the.bus.eventBoard.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import what.the.bus.eventBoard.EventBoardVO;
import what.the.bus.eventBoard.dao.EventBoardDAO;
import what.the.bus.eventBoard.service.InsertEventBoardService;

@Service
public class InsertEventBoardServiceImpl implements InsertEventBoardService{

	@Autowired
	private EventBoardDAO eventboardDAO;

	@Override
	public void insertEventBoard(EventBoardVO vo) {
		eventboardDAO.insertEventBoard(vo);
		
	}
	
	
}
