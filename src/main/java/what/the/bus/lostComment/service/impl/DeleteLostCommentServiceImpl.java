package what.the.bus.lostComment.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import what.the.bus.lostComment.dao.LostCommentDAO;
import what.the.bus.lostComment.service.DeleteLostCommentService;

@Service
public class DeleteLostCommentServiceImpl implements DeleteLostCommentService {

	@Autowired
	private LostCommentDAO lostCommentDAO;

	@Override
	public void deleteLostComment(int cno) {

		lostCommentDAO.deleteLostComment(cno);

	}

}
