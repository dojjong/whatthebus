package what.the.bus.lostComment.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import what.the.bus.lostComment.LostCommentVO;
import what.the.bus.lostComment.dao.LostCommentDAO;
import what.the.bus.lostComment.service.InsertLostCommentService;

@Service
public class InsertLostCommentServiceImpl implements InsertLostCommentService {

	@Autowired
	private LostCommentDAO lostCommentDAO;
	
	@Override
	public void insertLostComment(LostCommentVO vo) {
		lostCommentDAO.insertLostComment(vo);
	}

	@Override
	public List<LostCommentVO> getLostCommentList(LostCommentVO vo) {
		return lostCommentDAO.getLostCommentList(vo);			
				
	}

}
