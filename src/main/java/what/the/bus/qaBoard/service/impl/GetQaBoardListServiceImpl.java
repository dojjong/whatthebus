package what.the.bus.qaBoard.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import what.the.bus.qaBoard.QaBoardVO;
import what.the.bus.qaBoard.dao.impl.QaBoardDAOImpl;
import what.the.bus.qaBoard.service.GetQaBoardListService;

@Service
public class GetQaBoardListServiceImpl implements GetQaBoardListService{
	@Autowired
	private QaBoardDAOImpl qaBoardDAO;
	
	public void setQaBoardDAO(QaBoardDAOImpl qaBoardDAO) {
		this.qaBoardDAO = qaBoardDAO;
	}

	@Override
	public List<QaBoardVO> getQaBoardList() {
		return qaBoardDAO.getQaBoardList();
	}

	@Override
	public Integer getQaBoardListCount(QaBoardVO vo) {
		return qaBoardDAO.getQaBoardListCount();
	}
	
	

}
