package what.the.bus.bookcomment.service;

import java.util.List;

import what.the.bus.bookcomment.BookCommentVO;

public interface InsertBookCommentService {
	void insertBookComment(BookCommentVO vo);

	List<BookCommentVO> getBookCommentList(BookCommentVO vo);

}
