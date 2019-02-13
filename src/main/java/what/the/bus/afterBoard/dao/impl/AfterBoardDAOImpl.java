package what.the.bus.afterBoard.dao.impl;



import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import what.the.bus.afterBoard.AfterBoardVO;
import what.the.bus.afterBoard.dao.AfterBoardDAO;

@Repository
public class AfterBoardDAOImpl implements AfterBoardDAO{

	@Autowired
	private SqlSession mybatis;

	@Override
	public void insertAfterBoard(AfterBoardVO vo) throws Exception {
		mybatis.insert("AfterBoardDAO.insertAfterBoard", vo);
	}

	@Override
	public AfterBoardVO getAfterBoard(int seq) throws Exception {
		return mybatis.selectOne("AfterBoardDAO.getAfterBoard", seq);
	}

	@Override
	public void updateAfterBoard(AfterBoardVO vo) throws Exception {
		mybatis.update("AfterBoardDAO.updateAfterBoard", vo);
	}
	

	@Override
	public void deleteAfterBoard(int seq) throws Exception {
		mybatis.delete("AfterBoardDAO.deleteAfterBoard", seq);
		
	}

	@Override
	public List<AfterBoardVO> getAfterBoardList(int start, int end) throws Exception {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("start", start);
		map.put("end", end);
		return mybatis.selectList("AfterBoardDAO.getAfterBoardList", map);
	}

	@Override
	public void increaseViewCnt(int seq) throws Exception {
		mybatis.update("AfterBoardDAO.increaseViewCnt", seq);
	}

	@Override
	public List<AfterBoardVO> getAfterBoardList_writer(String keyword) throws Exception {
		return mybatis.selectList("AfterBoardDAO.getAfterBoardList_writer", keyword);
	}

	@Override
	public List<AfterBoardVO> getAfterBoardList_title(String keyword) throws Exception {
		return mybatis.selectList("AfterBoardDAO.getAfterBoardList_title", keyword);
	}

	@Override
	public List<AfterBoardVO> getAfterBoardList_title_content(String keyword) throws Exception {
		return mybatis.selectList("AfterBoardDAO.getAfterBoardList_title_content", keyword);
	}

	@Override
	public Integer countAfterBoardList() throws Exception {
		return mybatis.selectOne("AfterBoardDAO.countAfterBoardList");
	}

	@Override
	public Integer countAfterBoardList_title(String keyword) throws Exception {
		return mybatis.selectOne("AfterBoardDAO.countAfterBoardList_title", keyword);
	}

	@Override
	public Integer countAfterBoardList_writer(String keyword) throws Exception {
		return mybatis.selectOne("AfterBoardDAO.countAfterBoardList_writer", keyword);
	}

	@Override
	public Integer countAfterBoardList_title_content(String keyword) throws Exception {
		return mybatis.selectOne("AfterBoardDAO.countAfterBoardList_title_content", keyword);
	}

	
}
