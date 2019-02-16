package what.the.bus.bookcomment.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import what.the.bus.bookcomment.BookCommentVO;
import what.the.bus.bookcomment.dao.impl.BookCommentDAOImpl;
import what.the.bus.bookcomment.service.GetBookCommentService;
@Service
public class GetBookCommentServiceImpl implements GetBookCommentService {

	@Autowired
	private BookCommentDAOImpl commentDAO;

	@Override
	public BookCommentVO getBookComment(int cno) {
		return commentDAO.getBookComment(cno);
	}


}
