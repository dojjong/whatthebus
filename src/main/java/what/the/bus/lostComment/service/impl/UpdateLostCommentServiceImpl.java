package what.the.bus.lostComment.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import what.the.bus.lostComment.LostCommentVO;
import what.the.bus.lostComment.dao.LostCommentDAO;
import what.the.bus.lostComment.service.UpdateLostCommentService;

@Service
public class UpdateLostCommentServiceImpl implements UpdateLostCommentService {
	
	@Autowired
	private LostCommentDAO lostCommentDAO;
	
	@Override
	public void updateLostComment(LostCommentVO vo) {
		lostCommentDAO.updateLostComment(vo);
	}

}
