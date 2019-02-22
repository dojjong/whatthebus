package what.the.bus.admin.dao;

import java.util.List;

import what.the.bus.admin.AdminVO;
import what.the.bus.driver.DriverVO;
import what.the.bus.member.MemberVO;

public interface AdminDAO {
	List<MemberVO> getAllMemberList(); // 02.07

	int getBestCount();

	void setBestCount(int bestCount);

	List<DriverVO> getApprovalDriverList();

	void setStateCount(String id);

	void insertBanner(AdminVO vo);

	List<AdminVO> getBannerList(); // 02.21

	List<MemberVO> getMemberList();

	List<DriverVO> getDriverList();

	void expulsionMember(String id);

	void expulsionDriver(String id);
}
