package what.the.bus.bookcomment.dao.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

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

	@Override
	public void deleteAdminBookComment(int cno) {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("content", "관리자에 의해 삭제된 댓글입니다.");
		map.put("id", "admin");
		map.put("name", "관리자");
		map.put("cno", cno);
		mybatis.update("BookCommentDAO.deleteAdminBookComment", map);
	}

}
