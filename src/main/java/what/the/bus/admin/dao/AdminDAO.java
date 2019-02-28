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

	int getExpulstionMember(String id);

	int getExpulstionDriver(String id);

	void returnMember(String id);

	void returnDriver(String id);

	List<MemberVO> searchMember(String searchOption, String keyword);

	void updateBanner(AdminVO vo);

	void deleteBanner(int seq);

	MemberVO getMemberOne(String id);

	void selectMemberAdminSpecify(String id);

	void selectDriverAdminSpecify(String id);

	void setMainCount(int mainCount);
}
