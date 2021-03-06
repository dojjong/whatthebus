package what.the.bus.qaComment.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import what.the.bus.qaComment.dao.QaCommentDAO;
import what.the.bus.qaComment.service.DeleteQaCommentService;
@Service
public class DeleteQaCommentServiceImpl implements DeleteQaCommentService{

	@Autowired
	private QaCommentDAO qaCommentDAO;
	
	@Override
	public void deleteQaComment(int cno) {
		qaCommentDAO.deleteQaComment(cno);
	}

}
