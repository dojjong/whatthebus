package what.the.bus.qaBoard.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import what.the.bus.qaBoard.QaBoardVO;
import what.the.bus.qaBoard.dao.impl.QaBoardDAOImpl;
import what.the.bus.qaBoard.service.DeleteQaBoardService;

@Service
public class DeleteQaBoardServiceImpl implements DeleteQaBoardService{
	
	@Autowired
	private QaBoardDAOImpl qaBoardDAO;
	

	@Override
	public void deleteQaBoard(QaBoardVO vo) {
		qaBoardDAO.deleteQaBoard(vo);
	}

	@Override
	public QaBoardVO getQaBoard(int seq) {
		return qaBoardDAO.getQaBoard(seq);
	}

}
