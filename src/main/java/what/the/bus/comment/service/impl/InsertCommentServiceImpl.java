package what.the.bus.comment.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import what.the.bus.comment.CommentVO;
import what.the.bus.comment.dao.CommentDAO;
import what.the.bus.comment.service.InsertCommentService;

@Service
public class InsertCommentServiceImpl implements InsertCommentService {
	@Autowired
	private CommentDAO commentDAO;

	@Override
	public void insertComment(CommentVO vo) {
		commentDAO.insertComment(vo);
	}

	@Override
	public List<CommentVO> getCommentList(CommentVO vo) {
		return commentDAO.getCommentList(vo);
	}
}
