package what.the.bus.lostComment.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import what.the.bus.lostComment.LostCommentVO;
import what.the.bus.lostComment.dao.impl.LostCommentDAOImpl;
import what.the.bus.lostComment.service.GetLostCommentService;

@Service
public class GetLostCommentServiceImpl implements GetLostCommentService {

		@Autowired
		private LostCommentDAOImpl lostCommentDAO;
	
	@Override
	public LostCommentVO getLostComment(int cno) {
		return lostCommentDAO.getLostComment(cno);
	}

}
