package what.the.bus.qaBoard.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import what.the.bus.qaBoard.QaBoardVO;
import what.the.bus.qaBoard.dao.QaBoardDAO;
import what.the.bus.qaBoard.dao.impl.QaBoardDAOImpl;
import what.the.bus.qaBoard.service.GetQaBoardListService;
import what.the.bus.qaComment.QaCommentVO;

@Service
public class GetQaBoardListServiceImpl implements GetQaBoardListService{
	@Autowired
	private QaBoardDAO qaBoardDAO;
	
	public void setQaBoardDAO(QaBoardDAOImpl qaBoardDAO) {
		this.qaBoardDAO = qaBoardDAO;
	}

	@Override
	public List<QaBoardVO> getQaBoardList(int start, int end, String searchOption, String keyword) {
		return qaBoardDAO.getQaBoardList(start, end, searchOption, keyword);
	}
	

	@Override
	public Integer getQaBoardListCount(QaBoardVO vo) {
		return qaBoardDAO.getQaBoardListCount(vo);
	}

	

	@Override
	public Integer getQaBoardCommentContentListCount(QaCommentVO vo) {
		return qaBoardDAO.getQaBoardCommentContentListCount(vo);
	}

	@Override
	public Integer getQaBoardCommentNameListCount(QaCommentVO vo) {
		return qaBoardDAO.getQaBoardCommentNameListCount(vo);
	}

	@Override
	public Integer getQaCommentCount(int seq) {
		return qaBoardDAO.getQaCommentCount(seq);
	}



	
	
	

}
