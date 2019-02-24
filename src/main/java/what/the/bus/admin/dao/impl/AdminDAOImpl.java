package what.the.bus.admin.dao.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
		mybatis.update("AdminDAO.expulsionMember", id);
	}

	@Override
	public void expulsionDriver(String id) {
		mybatis.update("AdminDAO.expulsionDriver", id);
	}

	@Override
	public int getExpulstionMember(String id) {
		return mybatis.selectOne("AdminDAO.getExpulstionMember", id);
	}

	@Override
	public int getExpulstionDriver(String id) {
		return mybatis.selectOne("AdminDAO.getExpulstionDriver", id);
	}

	@Override
	public void returnMember(String id) {
		mybatis.update("AdminDAO.returnMember", id);
	}

	@Override
	public void returnDriver(String id) {
		mybatis.update("AdminDAO.returnDriver", id);
	}

	@Override
	public List<MemberVO> searchMember(String searchOption, String keyword) {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("searchOption", searchOption);
		map.put("keyword", keyword);
		return mybatis.selectList("AdminDAO.searchMember", map);
	}

	@Override
	public void updateBanner(AdminVO vo) {
		mybatis.update("AdminDAO.updateBanner", vo);
	}

	@Override
	public void deleteBanner(int seq) {
		mybatis.delete("AdminDAO.deleteBanner", seq);
	}

}
