package what.the.bus.comment.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import what.the.bus.comment.CommentVO;
import what.the.bus.comment.dao.CommentDAO;
import what.the.bus.comment.service.GetCommentService;

@Service
public class GetCommentServiceImpl implements GetCommentService {
	@Autowired
	private CommentDAO commentDAO;

	@Override
	public CommentVO getComment(int cno) {
		return commentDAO.getComment(cno);
	}

}
