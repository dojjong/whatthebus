package what.the.bus.admin.dao.impl;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import what.the.bus.admin.dao.AdminDAO;
import what.the.bus.member.MemberVO;
import what.the.bus.util.SqlSessionFactoryBean;

@Repository
public class AdminDAOImpl implements AdminDAO{
	
	@Autowired
	private SqlSession mybatis;
	
	
	public AdminDAOImpl() {
		mybatis = SqlSessionFactoryBean.getSqlSessionInstance();
	}
	
	//02.07
	public List<MemberVO> getMemberList() {
		return mybatis.selectList("AdminDAO.getMemberList");
	}
	

}