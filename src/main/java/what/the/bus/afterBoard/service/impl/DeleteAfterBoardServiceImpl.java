package what.the.bus.afterBoard.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import what.the.bus.afterBoard.dao.impl.AfterBoardDAOImpl;
import what.the.bus.afterBoard.service.DeleteAfterBoardService;

@Service
public class DeleteAfterBoardServiceImpl implements DeleteAfterBoardService{

	@Autowired
	AfterBoardDAOImpl afterBoardDAO;

	@Override
	public void deleteAfterBoard(int seq) throws Exception {
		afterBoardDAO.deleteAfterBoard(seq);
		
	}
	
}
