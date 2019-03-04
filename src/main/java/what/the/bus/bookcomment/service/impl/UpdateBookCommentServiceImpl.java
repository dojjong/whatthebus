package what.the.bus.bookcomment.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import what.the.bus.bookcomment.BookCommentVO;
import what.the.bus.bookcomment.dao.BookCommentDAO;
import what.the.bus.bookcomment.service.UpdateBookCommentService;
@Service
public class UpdateBookCommentServiceImpl implements UpdateBookCommentService {
	@Autowired
	private BookCommentDAO commentDAO;

	@Override
	public void updateBookComment(BookCommentVO vo) {
		commentDAO.updateBookComment(vo);
	}

}
