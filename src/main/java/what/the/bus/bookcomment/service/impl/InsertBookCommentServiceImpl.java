package what.the.bus.bookcomment.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import what.the.bus.bookcomment.BookCommentVO;
import what.the.bus.bookcomment.dao.BookCommentDAO;
import what.the.bus.bookcomment.service.InsertBookCommentService;
@Service
public class InsertBookCommentServiceImpl implements InsertBookCommentService {

	@Autowired
	private BookCommentDAO commentDAO;

	@Override
	public void insertBookComment(BookCommentVO vo) {
		commentDAO.insertBookComment(vo);
	}

	@Override
	public List<BookCommentVO> getBookCommentList(BookCommentVO vo) {
		return commentDAO.getBookCommentList(vo);
	}

}
