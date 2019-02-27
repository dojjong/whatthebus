package what.the.bus.comment.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import what.the.bus.comment.CommentVO;
import what.the.bus.comment.dao.impl.CommentDAOImpl;
import what.the.bus.comment.service.DeleteCommentService;

@Service
public class DeleteCommentServiceImpl implements DeleteCommentService {
	@Autowired
	private CommentDAOImpl commentDAO;

	@Override
	public void deleteComment(int cno) {
		commentDAO.deleteComment(cno);
	}

	@Override
	public void deleteAdminComment(int cno) {
		commentDAO.deleteAdminComment(cno);
	}
}
