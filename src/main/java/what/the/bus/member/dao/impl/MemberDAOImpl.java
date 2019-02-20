package what.the.bus.member.dao.impl;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import what.the.bus.board.ChartVO1;
import what.the.bus.member.MemberVO;
import what.the.bus.member.dao.MemberDAO;
import what.the.bus.util.SqlSessionFactoryBean;

@Repository
public class MemberDAOImpl implements MemberDAO {
	@Autowired
	private SqlSession mybatis;

	public MemberDAOImpl() {
		mybatis = SqlSessionFactoryBean.getSqlSessionInstance();
	}

	public void insertMember(MemberVO vo) {
		mybatis.insert("MemberDAO.insertMember", vo);
	}

	public void insertKakaoMember(MemberVO vo) {
		mybatis.insert("MemberDAO.insertKakaoMember", vo);
	}

	public void insertNaverMember(MemberVO vo) {
		mybatis.insert("MemberDAO.insertNaverMember", vo);
	}
	
	public void updateMember(MemberVO vo) {
		mybatis.update("MemberDAO.updateMember", vo);
	}

	public void deleteMember(MemberVO vo) {
		mybatis.update("MemberDAO.deleteMember", vo);

	}

	public MemberVO loginMember(MemberVO vo) {
		return mybatis.selectOne("MemberDAO.loginMember", vo);
	}

	public void pwUpdateMember(MemberVO vo) {
		mybatis.update("MemberDAO.pwUpdateMember", vo);
	}

	public int checkMember(String checkMember) {
		return mybatis.selectOne("MemberDAO.checkMember", checkMember);
	}

	@Override
	public String checkEmail(String checkEmail) {
		return mybatis.selectOne("MemberDAO.checkEmail", checkEmail);
	}

	// 01.31 추가
	public String checkName(String checkName) {
		return mybatis.selectOne("MemberDAO.checkName", checkName);
	}
	
	@Override
	public List<ChartVO1> getMemberCountPerRegdateJson() {
		return mybatis.selectList("MemberDAO.getMemberCountPerRegdateJson");
	}

}
