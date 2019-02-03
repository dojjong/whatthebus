package what.the.bus.comment.service;

import java.util.List;

import what.the.bus.comment.CommentVO;

public interface InsertCommentService {
	void insertComment(CommentVO vo);

	List<CommentVO> getCommentList(CommentVO vo);
}
