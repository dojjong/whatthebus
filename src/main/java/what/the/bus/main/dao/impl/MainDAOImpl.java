package what.the.bus.main.dao.impl;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import what.the.bus.board.BoardVO;
import what.the.bus.main.dao.MainDAO;
import what.the.bus.member.MemberVO;
import what.the.bus.noticeBoard.NoticeBoardVO;
import what.the.bus.suggestBoard.SuggestBoardVO;

@Repository
public class MainDAOImpl implements MainDAO {
	@Autowired
	private SqlSession mybatis;

	@Override
	public String getId(MemberVO vo) {
		return mybatis.selectOne("MainDAO.getId", vo);
	}

	@Override
	public int getIdCheck(MemberVO vo) {
		return mybatis.selectOne("MainDAO.getIdCheck", vo);
	}

	@Override
	public int getPWCheck(MemberVO vo) {
		return mybatis.selectOne("MainDAO.getPWCheck", vo);
	}

	@Override
	public int idCheckMember(MemberVO vo) {
		return mybatis.selectOne("MainDAO.idCheckMember", vo);
	}

	@Override
	public int idCheckDriver(MemberVO vo) {
		return mybatis.selectOne("MainDAO.idCheckDriver", vo);
	}

	@Override
	public void updatePWMember(MemberVO vo) {
		mybatis.update("MainDAO.updatePWMember", vo);
	}

	@Override
	public void updatePWDriver(MemberVO vo) {
		mybatis.update("MainDAO.updatePWDriver", vo);
	}

	@Override
	public List<BoardVO> hotList(int maincount) {
		return mybatis.selectList("MainDAO.hotList", maincount);
	}

	@Override
	public List<BoardVO> recentList(int maincount) {
		return mybatis.selectList("MainDAO.recentList", maincount);
	}

	@Override
	public List<SuggestBoardVO> finishTimeList(int maincount) {
		return mybatis.selectList("MainDAO.finishTimeList", maincount);
	}

	@Override
	public List<NoticeBoardVO> noticeList(int maincount) {
		return mybatis.selectList("MainDAO.noticeList", maincount);
	}

	@Override
	public int getMainCount() {
		return mybatis.selectOne("MainDAO.getMainCount");
	}

}
