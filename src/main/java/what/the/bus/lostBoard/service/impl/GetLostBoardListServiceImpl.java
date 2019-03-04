package what.the.bus.lostBoard.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import what.the.bus.lostBoard.LostBoardVO;
import what.the.bus.lostBoard.dao.LostBoardDAO;
import what.the.bus.lostBoard.impl.LostBoardDAOImpl;
import what.the.bus.lostBoard.service.GetLostBoardListService;
import what.the.bus.lostComment.LostCommentVO;

@Service
public class GetLostBoardListServiceImpl implements GetLostBoardListService {

	@Autowired
	private LostBoardDAO lostBoardDAO;
	
	public void setLostBoardDAO(LostBoardDAOImpl lostBoardDAO) {
		this.lostBoardDAO = lostBoardDAO;
	}
	
	@Override
	public List<LostBoardVO> getLostBoardList(int start, int end, String searchOption, String keyword) {
		return lostBoardDAO.getLostBoardList(start, end, searchOption, keyword);
	}

	@Override
	public Integer getLostBoardListCount(LostBoardVO vo) {
		return lostBoardDAO.getLostBoardListCount(vo);
	}
	
	@Override
	public Integer getLostBoardCommentContentListCount(LostCommentVO vo) {
		return lostBoardDAO.getLostBoardCommentContentListCount(vo);
	}
	
	@Override
	public Integer getLostBoardCommentNameListCount(LostCommentVO vo) {
		return lostBoardDAO.getLostBoardCommentNameListCount(vo);
	}
	
	@Override
	public Integer getLostCommentCount(int seq) {
		return lostBoardDAO.getLostCommentCount(seq);
	}
	
}
