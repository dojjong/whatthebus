package what.the.bus.qaBoard.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import what.the.bus.qaBoard.QaBoardVO;
import what.the.bus.qaBoard.dao.QaBoardDAO;
import what.the.bus.qaBoard.service.UpdateQaBoardService;

@Service
public class UpdateQaBoardServiceImpl implements UpdateQaBoardService{

	@Autowired
	private QaBoardDAO qaBoardDAO;
	
	
	@Override
	public void updateQaBoard(QaBoardVO vo) {
		qaBoardDAO.updateQaBoard(vo);
		
	}
	
	@Override
	public QaBoardVO getQaBoard(int seq) {
		return qaBoardDAO.getQaBoard(seq);
	}
	

}
