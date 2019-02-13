package what.the.bus.qaComment.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import what.the.bus.qaComment.QaCommentVO;
import what.the.bus.qaComment.dao.impl.QaCommentDAOImpl;
import what.the.bus.qaComment.service.InsertQaCommentService;

@Service
public class InsertQaCommentServiceImpl implements InsertQaCommentService{

	@Autowired
	private QaCommentDAOImpl qaCommentDAO;
	
	
	@Override
	public void insertQaComment(QaCommentVO vo) {
		qaCommentDAO.insertQaComment(vo);
		
	}

	@Override
	public List<QaCommentVO> getQaCommentList(QaCommentVO vo) {
		return qaCommentDAO.getQaCommentList(vo);
	}
	

}
