package what.the.bus.comment.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import what.the.bus.comment.CommentVO;
import what.the.bus.comment.dao.CommentDAO;
import what.the.bus.comment.service.UpdateCommentService;

@Service
public class UpdateCommentServiceImpl implements UpdateCommentService {
	@Autowired
	private CommentDAO commentDAO;

	@Override
	public void updateComment(CommentVO vo) {
		commentDAO.updateComment(vo);
	}

}
