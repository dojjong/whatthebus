package what.the.bus.noticeBoard.dao.impl;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import what.the.bus.noticeBoard.NoticeBoardVO;
import what.the.bus.noticeBoard.dao.NoticeBoardDAO;
import what.the.bus.util.SqlSessionFactoryBean;

@Repository
public class NoticeBoardDAOImpl implements NoticeBoardDAO{

	@Autowired
	private SqlSession mybatis;
	
	public NoticeBoardDAOImpl() {
		mybatis = SqlSessionFactoryBean.getSqlSessionInstance();
	}
	
	@Override
	public void insertNoticeBoard(NoticeBoardVO vo) {
		mybatis.insert("NoticeBoardDAO.insertNoticeBoard", vo);
	}

	@Override
	public List<NoticeBoardVO> getNoticeBoardList() {
		return mybatis.selectList("NoticeBoardDAO.getNoticeBoardList");
	}

	@Override
	public NoticeBoardVO getNoticeBoard(int seq) {
		return mybatis.selectOne("NoticeBoardDAO.getNoticeBoard", seq);
	}

	@Override
	public void updateNoticeBoard(NoticeBoardVO vo) {
		mybatis.update("NoticeBoardDAO.updateNoticeBoard", vo);
	}

	@Override
	public void deleteNoticeBoard(NoticeBoardVO vo) {
		mybatis.delete("NoticeBoardDAO.deleteNoticeBoard", vo);
	}

	@Override
	public int getNoticeBoardListCount() {
		return mybatis.selectOne("NoticeBoardDAO.getNoticeBoardListCount");
	}

}
