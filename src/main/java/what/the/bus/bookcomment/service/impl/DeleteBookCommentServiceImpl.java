package what.the.bus.bookcomment.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import what.the.bus.bookcomment.dao.BookCommentDAO;
import what.the.bus.bookcomment.service.DeleteBookCommentService;

@Service
public class DeleteBookCommentServiceImpl implements DeleteBookCommentService {

	@Autowired
	private BookCommentDAO commentDAO;

	@Override
	public void deleteBookComment(int cno) {
		commentDAO.deleteBookComment(cno);
	}

	@Override
	public void deleteAdminBookComment(int cno) {
		commentDAO.deleteAdminBookComment(cno);
	}

}
