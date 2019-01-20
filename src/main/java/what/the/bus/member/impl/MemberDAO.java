package what.the.bus.member.impl;

import org.apache.ibatis.session.SqlSession;

import what.the.bus.member.MemberVO;
import what.the.bus.util.SqlSessionFactoryBean;

public class MemberDAO {
	private SqlSession mybatis;

	public MemberDAO() {
		mybatis = SqlSessionFactoryBean.getSqlSessionInstance();
	}

	public void insertBoard(MemberVO vo) {
		mybatis.insert("MemberDAO.insertMember", vo);
		mybatis.commit();
	}

}
