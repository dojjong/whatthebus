package what.the.bus.board.dao.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import what.the.bus.best.BestVO;
import what.the.bus.board.BoardVO;
import what.the.bus.board.dao.BoardDAO;
import what.the.bus.comment.CommentVO;
import what.the.bus.util.SqlSessionFactoryBean;

@Repository
public class BoardDAOImpl implements BoardDAO {
	@Autowired
	private SqlSession mybatis;

	public BoardDAOImpl() {
		mybatis = SqlSessionFactoryBean.getSqlSessionInstance();
	}

	@Override
	public void insertBoard(BoardVO vo) {
		mybatis.insert("BoardDAO.insertBoard", vo);
	}

	@Override
	public List<BoardVO> getBoardList(int start, int end, String searchOption, String keyword) {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("searchOption", searchOption);
		map.put("keyword", keyword);
		map.put("start", start);
		map.put("end", end);
		return mybatis.selectList("BoardDAO.getBoardList", map);
	}

	@Override
	public int getListCount(BoardVO vo) {
		return mybatis.selectOne("BoardDAO.getListCount", vo);
	}

	@Override
	public BoardVO getBoard(int seq) {
		mybatis.update("BoardDAO.updateCnt", seq);
		return mybatis.selectOne("BoardDAO.getBoard", seq);
	}

	@Override
	public void updateBoard(BoardVO vo) {
		mybatis.update("BoardDAO.updateBoard", vo);
	}

	@Override
	public void deleteBoard(BoardVO vo) {
		mybatis.delete("BoardDAO.deleteBoard", vo);
	}

	@Override
	public void deleteComment(BoardVO vo) {
		mybatis.delete("BoardDAO.deleteComment", vo);
	}

	@Override
	public int getCheckBest(BestVO vo) {
		return mybatis.selectOne("BestDAO.getCheckBest", vo);
	}

	@Override
	public int getCheckBestCheck(BestVO vo) {
		return mybatis.selectOne("BestDAO.getCheckBestCheck", vo);
	}

	@Override
	public int getBoardCommentContentListCount(CommentVO vo) {
		return mybatis.selectOne("BoardDAO.getBoardCommentContentListCount", vo);
	}

	@Override
	public int getBoardCommentNameListCount(CommentVO vo) {
		return mybatis.selectOne("BoardDAO.getBoardCommentNameListCount", vo);
	}

	@Override
	public int getCommentCount(int seq) {
		return mybatis.selectOne("BoardDAO.getCommentCount", seq);
	}

}
