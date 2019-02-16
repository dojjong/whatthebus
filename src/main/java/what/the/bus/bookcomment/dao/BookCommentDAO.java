package what.the.bus.bookcomment.dao;

import java.util.List;

import what.the.bus.bookcomment.BookCommentVO;

public interface BookCommentDAO {
	void insertBookComment(BookCommentVO vo);

	List<BookCommentVO> getBookCommentList(BookCommentVO vo);

	void deleteBookComment(int cno);

	BookCommentVO getBookComment(int cno);

	void updateBookComment(BookCommentVO vo);
}
