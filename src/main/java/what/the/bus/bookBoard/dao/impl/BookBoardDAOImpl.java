package what.the.bus.bookBoard.dao.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import what.the.bus.admin.ReportVO2;
import what.the.bus.bookBoard.dao.BookBoardDAO;
import what.the.bus.bookcomment.BookCommentVO;
import what.the.bus.suggestBoard.SuggestBoardVO;
import what.the.bus.util.SqlSessionFactoryBean;

@Repository
public class BookBoardDAOImpl implements BookBoardDAO {
	@Autowired
	private SqlSession mybatis;

	public BookBoardDAOImpl() {
		mybatis = SqlSessionFactoryBean.getSqlSessionInstance();
	}

	public void insertBookBoard(SuggestBoardVO vo) {
		mybatis.insert("BookBoardDAO.insertBookBoard", vo);
	}

	@Override
	public List<SuggestBoardVO> getBookBoardList(int start, int end, String searchOption, String keyword) {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("searchOption", searchOption);
		map.put("keyword", keyword);
		map.put("start", start);
		map.put("end", end);
		return mybatis.selectList("BookBoardDAO.getBookBoardList", map);
	}

	@Override
	public int getBookBoardListCount(SuggestBoardVO vo) {
		return mybatis.selectOne("BookBoardDAO.getBookBoardListCount", vo);
	}

	@Override
	public SuggestBoardVO getBookBoard(int seq) {
		return mybatis.selectOne("BookBoardDAO.getBookBoard", seq);
	}

	@Override
	public void updateBookBoard(SuggestBoardVO vo) {
		mybatis.update("BookBoardDAO.updateBookBoard", vo);
	}

	@Override
	public void deleteBookBoard(SuggestBoardVO vo) {
		mybatis.update("BookBoardDAO.deleteBookBoard", vo);
	}

	@Override
	public int getBoardCommentContentListCount(BookCommentVO vo) {
		return mybatis.selectOne("BookBoardDAO.getBoardCommentContentListCount", vo);
	}

	@Override
	public int getBoardCommentNameListCount(BookCommentVO vo) {
		return mybatis.selectOne("BookBoardDAO.getBoardCommentNameListCount", vo);
	}

	@Override
	public int getCommentCount(int seq) {
		return mybatis.selectOne("BookBoardDAO.getCommentCount", seq);
	}

	@Override
	public int getListCount(SuggestBoardVO vo) {
		return mybatis.selectOne("BookBoardDAO.getBookBoardListCount", vo);
	}
	@Override
	public List<SuggestBoardVO> cluster() {
		return mybatis.selectList("BookBoardDAO.cluster");
	}

	@Override
	public List<ReportVO2> getBookBoardListReport(SuggestBoardVO vo) {
		return mybatis.selectList("BookBoardDAO.getBookBoardListReport", vo);
	}

}
