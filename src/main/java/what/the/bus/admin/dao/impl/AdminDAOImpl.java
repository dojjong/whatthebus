package what.the.bus.admin.dao.impl;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import what.the.bus.admin.AdminVO;
import what.the.bus.admin.dao.AdminDAO;
import what.the.bus.driver.DriverVO;
import what.the.bus.member.MemberVO;

@Repository
public class AdminDAOImpl implements AdminDAO {

	@Autowired
	private SqlSession mybatis;

	// 02.07
	public List<MemberVO> getAllMemberList() {
		return mybatis.selectList("AdminDAO.getAllMemberList");
	}

	public List<DriverVO> getApprovalDriverList() {
		return mybatis.selectList("AdminDAO.getApprovalDriverList");
	}

	@Override
	public int getBestCount() {
		return mybatis.selectOne("AdminDAO.getBestCount");
	}

	@Override
	public void setBestCount(int bestCount) {
		mybatis.update("AdminDAO.setBestCount", bestCount);
	}

	@Override
	public void setStateCount(String id) {
		mybatis.update("AdminDAO.setStateCount", id);
	}

	@Override
	public void insertBanner(AdminVO vo) {
		mybatis.insert("AdminDAO.insertBanner", vo);

	}

	@Override
	public List<AdminVO> getBannerList() {
		return mybatis.selectList("AdminDAO.getBannerList");
	}

	@Override
	public List<MemberVO> getMemberList() {
		return mybatis.selectList("AdminDAO.getMemberList");
	}

	@Override
	public List<DriverVO> getDriverList() {
		return mybatis.selectList("AdminDAO.getDriverList");
	}

	@Override
	public void expulsionMember(String id) {
		mybatis.update("AdminDAO.expulsionMember",id);
	}

	@Override
	public void expulsionDriver(String id) {
		mybatis.update("AdminDAO.expulsionDriver",id);
	}

}
