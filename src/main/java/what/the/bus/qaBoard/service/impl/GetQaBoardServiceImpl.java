package what.the.bus.qaBoard.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import what.the.bus.qaBoard.QaBoardVO;
import what.the.bus.qaBoard.dao.QaBoardDAO;
import what.the.bus.qaBoard.service.GetQaBoardService;

@Service
public class GetQaBoardServiceImpl implements GetQaBoardService{
	
	@Autowired
	private QaBoardDAO qaBoardDAO;

	@Override
	public QaBoardVO getQaBoard(int seq) {
		return qaBoardDAO.getQaBoard(seq);
	}
	
	

}
