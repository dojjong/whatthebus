package what.the.bus.qaBoard.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import what.the.bus.qaBoard.QaBoardVO;
import what.the.bus.qaBoard.dao.impl.QaBoardDAOImpl;
import what.the.bus.qaBoard.service.InsertQaBoardService;

@Service
public class InsertQaBoardServiceImpl implements InsertQaBoardService{

	@Autowired
	private QaBoardDAOImpl qaboardDAO;
	
	@Override
	public void insertQaBoard(QaBoardVO vo) {
		qaboardDAO.insertQaBoard(vo);
		
	}
	

}
