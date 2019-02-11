package what.the.bus.suggestBoard.dao.impl;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import what.the.bus.board.BoardVO;
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
	public List<SuggestBoardVO> getSuggestBoardList() {
		return mybatis.selectList("SuggestBoardDAO.getSuggestBoardList");
	}

	@Override
	public int getSuggestBoardListCount() {
		return mybatis.selectOne("SuggestBoardDAO.getSuggestBoardListCount");
	}

	@Override
	public BoardVO getSuggestBoard(int seq) {
		return mybatis.selectOne("SuggestBoardDAO.getSuggestBoard",seq);
	}

	@Override
	public void updateSuggestBoard(SuggestBoardVO vo) {
		mybatis.update("SuggestBoardDAO.updateSuggestBoard",vo);
	}
	
	@Override
	public void deleteSuggestBoard(SuggestBoardVO vo) {
		mybatis.delete("SuggestBoardDAO.deleteSuggestBoard", vo);
	}

	

}
