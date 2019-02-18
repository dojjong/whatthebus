package what.the.bus.admin.dao;

import java.util.List;

import what.the.bus.driver.DriverVO;
import what.the.bus.member.MemberVO;

public interface AdminDAO {
	List<MemberVO> getMemberList(); // 02.07

	int getBestCount();

	void setBestCount(int bestCount);

	List<DriverVO> getApprovalDriverList();

	void setStateCount(String id);
}
