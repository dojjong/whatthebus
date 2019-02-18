package what.the.bus.lostBoard.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import what.the.bus.lostBoard.LostBoardVO;
import what.the.bus.lostBoard.dao.LostBoardDAO;
import what.the.bus.lostComment.LostCommentVO;
import what.the.bus.util.SqlSessionFactoryBean;


@Repository
public class LostBoardDAOImpl implements LostBoardDAO {

	@Autowired
	private SqlSession mybatis;
	
	public LostBoardDAOImpl() {
		mybatis = SqlSessionFactoryBean.getSqlSessionInstance();
	}
	
	@Override
	public void insertLostBoard(LostBoardVO vo) {
		mybatis.insert("LostBoardDAO.insertLostBoard", vo);
	}

	
	@Override
	public List<LostBoardVO> getLostBoardList(int start, int end, String searchOption, String keyword) {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("searchOption", searchOption);
		map.put("keyword", keyword);
		map.put("start", start);
		map.put("end", end);
		return mybatis.selectList("LostBoardDAO.getLostBoardList", map);
	}
	
	@Override
	public int getLostBoardListCount(LostBoardVO vo) {
		return mybatis.selectOne("LostBoardDAO.getLostBoardListCount", vo);
	}
	
	@Override
	public LostBoardVO getLostBoard(int seq) {
		mybatis.update("LostBoardDAO.updateLostCnt", seq);
		return mybatis.selectOne("LostBoardDAO.getLostBoard", seq);
	}
	
	@Override
	public void updateLostBoard(LostBoardVO vo) {
		mybatis.update("LostBoardDAO.updateLostBoard", vo);
	}
	
	@Override
	public void deleteLostBoard(LostBoardVO vo) {
		mybatis.delete("LostBoardDAO.deleteLostBoard", vo);
	}
	
	@Override
	public void deleteLostComment(LostBoardVO vo) {
		mybatis.delete("LostBoardDAO.deleteLostComment", vo);
	}
	
	@Override
	public int getLostBoardCommentContentListCount(LostCommentVO vo) {
		return mybatis.selectOne("LostBoardDAO.getLostBoardCommentContentListCount", vo);
	}
	
	@Override
	public int getLostBoardCommentNameListCount(LostCommentVO vo) {
		return mybatis.selectOne("LostBoardDAO.getLostBoardCOmmentNameListCount", vo);
	}
	
	@Override
	public int getLostCommentCount(int seq) {
		return mybatis.selectOne("LostBoardDAO.getLostCommentCount", seq);
	}

	
	
	
	
	
	
	
}
