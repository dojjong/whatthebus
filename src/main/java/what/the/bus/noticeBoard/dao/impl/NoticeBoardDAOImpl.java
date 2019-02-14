package what.the.bus.noticeBoard.dao.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import what.the.bus.noticeBoard.NoticeBoardVO;
import what.the.bus.noticeBoard.dao.NoticeBoardDAO;
import what.the.bus.noticeComment.NoticeCommentVO;
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
	public List<NoticeBoardVO> getNoticeBoardList(int start, int end, String searchOption, String keyword) {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("searchOption", searchOption);
		map.put("keyword", keyword);
		map.put("start", start);
		map.put("end", end);
		return mybatis.selectList("NoticeBoardDAO.getNoticeBoardList", map);
	}
	


	@Override
	public NoticeBoardVO getNoticeBoard(int seq) {
		mybatis.update("NoticeBoardDAO.updateNoticeCnt", seq);
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
	public int getNoticeBoardListCount(NoticeBoardVO vo) {
		return mybatis.selectOne("NoticeBoardDAO.getNoticeBoardListCount", vo);
	}

	
	
	
	
	
	@Override
	public void deleteNoticeComment(NoticeBoardVO vo) {
		mybatis.delete("NoticeBoardDAO.deleteNoticeComment", vo);
		
		
	}

	@Override
	public int getNoticeCommentContentListCount(NoticeCommentVO vo) {
		return mybatis.selectOne("NoticeBoardDAO.getNoticeCommentContentListCount", vo);
	}

	@Override
	public int getNoticeCommentNameListCount(NoticeCommentVO vo) {
		return mybatis.selectOne("NoticeBoardDAO.getNoticeCommentNameListCount", vo);
	}

	@Override
	public int getNoticeCommentCount(int seq) {
		return mybatis.selectOne("NoticeBoardDAO.getNoticeCommentCount", seq);
	}

	

}
