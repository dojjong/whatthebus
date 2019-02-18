package what.the.bus.qaComment.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import what.the.bus.qaComment.QaCommentVO;
import what.the.bus.qaComment.dao.QaCommentDAO;
import what.the.bus.qaComment.service.GetQaCommentService;
@Service
public class GetQaCommentServiceImpl implements GetQaCommentService{

	@Autowired
	private QaCommentDAO qaCommentDAO;
	
	@Override
	public QaCommentVO getQaComment(int cno) {
		return qaCommentDAO.getQaComment(cno);
	}
	

}
