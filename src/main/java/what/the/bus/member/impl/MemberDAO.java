package what.the.bus.member.impl;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import what.the.bus.member.MemberVO;
import what.the.bus.util.SqlSessionFactoryBean;

@Repository
public class MemberDAO {
	@Autowired
	private SqlSession mybatis;

	public MemberDAO() {
		mybatis = SqlSessionFactoryBean.getSqlSessionInstance();
	}

	public void insertMember(MemberVO vo) {
		mybatis.insert("MemberDAO.insertMember", vo);
		mybatis.commit();
	}

	public void updateMember(MemberVO vo) {
		mybatis.insert("MemberDAO.updateMember", vo);
		mybatis.commit();
	}

	public void deleteMember(MemberVO vo) {
		mybatis.insert("MemberDAO.deleteMember", vo);
		mybatis.commit();
	}

	public MemberVO loginMember(MemberVO vo) {
		return mybatis.selectOne("MemberDAO.loginMember", vo);
	}
}
