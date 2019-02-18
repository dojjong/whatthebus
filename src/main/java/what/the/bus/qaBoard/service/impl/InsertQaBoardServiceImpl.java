package what.the.bus.qaBoard.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import what.the.bus.qaBoard.QaBoardVO;
import what.the.bus.qaBoard.dao.QaBoardDAO;
import what.the.bus.qaBoard.service.InsertQaBoardService;

@Service
public class InsertQaBoardServiceImpl implements InsertQaBoardService{

	@Autowired
	private QaBoardDAO qaboardDAO;
	
	@Override
	public void insertQaBoard(QaBoardVO vo) {
		qaboardDAO.insertQaBoard(vo);
		
	}
	

}
