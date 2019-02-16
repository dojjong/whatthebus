package what.the.bus.bookcomment.dao.impl;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import what.the.bus.bookcomment.BookCommentVO;
import what.the.bus.bookcomment.dao.BookCommentDAO;
import what.the.bus.util.SqlSessionFactoryBean;

@Repository
public class BookCommentDAOImpl implements BookCommentDAO {

	@Autowired
	private SqlSession mybatis;

	public BookCommentDAOImpl() {
		mybatis = SqlSessionFactoryBean.getSqlSessionInstance();
	}

	@Override
	public void insertBookComment(BookCommentVO vo) {
		mybatis.insert("BookCommentDAO.insertBookComment", vo);
	}

	@Override
	public List<BookCommentVO> getBookCommentList(BookCommentVO vo) {
		return mybatis.selectList("BookCommentDAO.getBookCommentList", vo);
	}

	@Override
	public void deleteBookComment(int cno) {
		mybatis.delete("BookCommentDAO.deleteBookComment", cno);
	}

	@Override
	public BookCommentVO getBookComment(int cno) {
		return mybatis.selectOne("BookCommentDAO.getBookComment", cno);
	}

	@Override
	public void updateBookComment(BookCommentVO vo) {
		mybatis.update("BookCommentDAO.updateBookComment", vo);
	}

}
