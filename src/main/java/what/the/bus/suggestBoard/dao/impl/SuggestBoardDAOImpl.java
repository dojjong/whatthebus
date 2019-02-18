package what.the.bus.suggestBoard.dao.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import what.the.bus.best.BestVO;
import what.the.bus.board.BoardVO;
import what.the.bus.comment.CommentVO;
import what.the.bus.suggestBoard.SuggestBoardVO;
import what.the.bus.suggestBoard.dao.SuggestBoardDAO;
import what.the.bus.util.SqlSessionFactoryBean;

@Repository
public class SuggestBoardDAOImpl implements SuggestBoardDAO {
	@Autowired
	private SqlSession mybatis;

	public SuggestBoardDAOImpl() {
		mybatis = SqlSessionFactoryBean.getSqlSessionInstance();
	}

	public void insertSuggestBoard(BoardVO vo) {
		mybatis.insert("SuggestBoardDAO.insertSuggestBoard", vo);
	}

	@Override
	public List<BoardVO> getSuggestBoardList(int start, int end, String searchOption, String keyword,int bestcount) {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("bestcount", bestcount);
		map.put("searchOption", searchOption);
		map.put("keyword", keyword);
		map.put("start", start);
		map.put("end", end);
		return mybatis.selectList("SuggestBoardDAO.getBoardList", map);
	}


	@Override
	public int getSuggestBoardListCount(BoardVO vo) {
		return mybatis.selectOne("SuggestBoardDAO.getSuggestBoardListCount", vo);
	}

	@Override
	public BoardVO getSuggestBoard(int seq) {
		mybatis.update("BoardDAO.updateCnt", seq);
		return mybatis.selectOne("BoardDAO.getBoard", seq);
	}

	@Override
	public void updateSuggestBoard(BoardVO vo) {
		mybatis.update("SuggestBoardDAO.updateBoard", vo);
	}

	@Override
	public void deleteSuggestBoard(BoardVO vo) {
		mybatis.delete("SuggestBoardDAO.deleteBoard", vo);
	}

	@Override
	public void deleteSuggestComment(BoardVO vo) {
		mybatis.delete("SuggestBoardDAO.deleteComment", vo);
	}

	@Override
	public int getCheckBest(BestVO vo) {
		return mybatis.selectOne("SuggestBoardDAO.getCheckBest", vo);
	}

	@Override
	public int getCheckBestCheck(BestVO vo) {
		return mybatis.selectOne("SuggestBoardDAO.getCheckBestCheck", vo);
	}

	@Override
	public int getBoardCommentContentListCount(CommentVO vo) {
		return mybatis.selectOne("SuggestBoardDAO.getBoardCommentContentListCount", vo);
	}

	@Override
	public int getBoardCommentNameListCount(CommentVO vo) {
		return mybatis.selectOne("SuggestBoardDAO.getBoardCommentNameListCount", vo);
	}

	@Override
	public int getCommentCount(int seq) {
		return mybatis.selectOne("SuggestBoardDAO.getCommentCount", seq);
	}

	@Override
	public void totalBestCount(BoardVO vo) {
		mybatis.update("SuggestBoardDAO.totalBestCount",vo);
	}
	

}
