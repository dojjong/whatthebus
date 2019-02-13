package what.the.bus.qaBoard.dao.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import what.the.bus.qaBoard.QaBoardVO;
import what.the.bus.qaBoard.dao.QaBoardDAO;
import what.the.bus.qaComment.QaCommentVO;
import what.the.bus.util.SqlSessionFactoryBean;

@Repository
public class QaBoardDAOImpl implements QaBoardDAO{
	
	@Autowired
	private SqlSession mybatis;

	
	public QaBoardDAOImpl() {
		mybatis = SqlSessionFactoryBean.getSqlSessionInstance();
	}


	@Override
	public void insertQaBoard(QaBoardVO vo) {
		mybatis.insert("QaBoardDAO.insertQaBoard", vo);
	}
	

	@Override
	public List<QaBoardVO> getQaBoardList(int start, int end, String searchOption, String keyword) {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("searchOption", searchOption);
		map.put("keyword", keyword);
		map.put("start", start);
		map.put("end", end);
		return mybatis.selectList("QaBoardDAO.getQaBoardList", map);
	}
	
	@Override
	public int getQaBoardListCount(QaBoardVO vo) {
		return mybatis.selectOne("QaBoardDAO.getQaBoardListCount", vo);
	}
	

	
	@Override
	public QaBoardVO getQaBoard(int seq) {
		return mybatis.selectOne("QaBoardDAO.getQaBoard", seq);
	}

	@Override
	public void updateQaBoard(QaBoardVO vo) {
		mybatis.update("QaBoardDAO.updateQaBoard", vo);
	}

	@Override
	public void deleteQaBoard(QaBoardVO vo) {
		mybatis.delete("QaBoardDAO.deleteQaBoard", vo);
		
	}


	@Override
	public void deleteQaComment(QaBoardVO vo) {
		mybatis.delete("QaBoardDAO.deleteQaComment", vo);
	}


	@Override
	public int getQaBoardCommentContentListCount(QaCommentVO vo) {
		return mybatis.selectOne("QaBoardDAO.getQaBoardCommentContentListCount", vo);
	}

	@Override
	public int getQaBoardCommentNameListCount(QaCommentVO vo) {
		return mybatis.selectOne("QaBoardDAO.getQaBoardCommentNameListCount", vo);
	}

	@Override
	public int getQaCommentCount(int seq) {
		return mybatis.selectOne("QaBoardDAO.getQaCommentCount", seq);
	}

	

	
	

}
