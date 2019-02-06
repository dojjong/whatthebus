package what.the.bus.comment.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import what.the.bus.comment.CommentVO;
import what.the.bus.comment.dao.impl.CommentDAOImpl;
import what.the.bus.comment.service.UpdateCommentService;

@Service
public class UpdateCommentServiceImpl implements UpdateCommentService {
	@Autowired
	private CommentDAOImpl commentDAO;

	@Override
	public void updateComment(CommentVO vo) {
		commentDAO.updateComment(vo);
	}

}
