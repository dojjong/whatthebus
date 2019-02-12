package what.the.bus.bookBoard.dao.impl;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import what.the.bus.bookBoard.BookBoardVO;
import what.the.bus.bookBoard.dao.BookBoardDAO;
import what.the.bus.suggestBoard.SuggestBoardVO;
import what.the.bus.util.SqlSessionFactoryBean;

@Repository
public class BookBoardDAOImpl implements BookBoardDAO {
	@Autowired
	private SqlSession mybatis;

	public BookBoardDAOImpl() {
		mybatis = SqlSessionFactoryBean.getSqlSessionInstance();
	}

	public void insertBookBoard(BookBoardVO vo) {
		mybatis.insert("BookBoardDAO.insertBookBoard", vo);
	}

	@Override
	public List<SuggestBoardVO> getBookBoardList() {
		return mybatis.selectList("BookBoardDAO.getBookBoardList");
	}

	@Override
	public int getBookBoardListCount() {
		return mybatis.selectOne("BookBoardDAO.getBookBoardListCount");
	}

	@Override
	public SuggestBoardVO getBookBoard(int seq) {
		return mybatis.selectOne("BookBoardDAO.getBookBoard",seq);
	}

	@Override
	public void updateBookBoard(BookBoardVO vo) {
		mybatis.update("BookBoardDAO.updateBookBoard",vo);
	}

	@Override
	public void deleteBookBoard(BookBoardVO vo) {
		mybatis.delete("BookBoardDAO.deleteBookBoard", vo);
	}

}
