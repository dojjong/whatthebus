package what.the.bus.noticeComment.dao.impl;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import what.the.bus.noticeComment.NoticeCommentVO;
import what.the.bus.noticeComment.dao.NoticeCommentDAO;
import what.the.bus.util.SqlSessionFactoryBean;

@Repository
public class NoticeCommentDAOImpl implements NoticeCommentDAO{
	
	@Autowired
	private SqlSession mybatis;
	
	

	public NoticeCommentDAOImpl() {
		mybatis = SqlSessionFactoryBean.getSqlSessionInstance();
	}



	@Override
	public void insertNoticeComment(NoticeCommentVO vo) {
		mybatis.insert("NoticeCommentDAO.insertNoticeComment", vo);
		
	}



	@Override
	public List<NoticeCommentVO> getNoticeCommentList(NoticeCommentVO vo) {
		return mybatis.selectList("NoticeCommentDAO.getNoticeCommentList", vo);
	}



	@Override
	public void deleteNoticeComment(int cno) {
		mybatis.delete("NoticeCommentDAO.deleteNoticeComment", cno);
	}



	@Override
	public NoticeCommentVO getNoticeComment(int cno) {
		return mybatis.selectOne("NoticeCommentDAO.getNoticeComment", cno);
	}



	@Override
	public void updateNoticeComment(NoticeCommentVO vo) {
		mybatis.update("NoticeCommentDAO.updateNoticeComment", vo);
		
	}



}
