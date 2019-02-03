package what.the.bus.comment.dao;

import java.util.List;

import what.the.bus.comment.CommentVO;

public interface CommentDAO {
	void insertComment(CommentVO vo);

	List<CommentVO> getCommentList(CommentVO vo);
}
