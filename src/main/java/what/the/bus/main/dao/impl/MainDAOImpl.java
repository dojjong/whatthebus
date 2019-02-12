package what.the.bus.main.dao.impl;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import what.the.bus.main.dao.MainDAO;
import what.the.bus.member.MemberVO;

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

}
