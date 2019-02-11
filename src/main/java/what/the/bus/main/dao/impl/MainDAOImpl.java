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

}
