package what.the.bus.qaComment.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import what.the.bus.qaComment.QaCommentVO;
import what.the.bus.qaComment.dao.QaCommentDAO;
import what.the.bus.qaComment.service.UpdateQaCommentService;

@Service
public class UpdateQaCommentServiceImpl implements UpdateQaCommentService{

	@Autowired
	private QaCommentDAO qaCommentDAO;
	
	@Override
	public void updateQaComment(QaCommentVO vo) {
		qaCommentDAO.updateQaComment(vo);
		
	}
	

}
