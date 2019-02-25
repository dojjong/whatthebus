package what.the.bus.admin.service;

import java.util.List;

import what.the.bus.driver.DriverVO;
import what.the.bus.member.MemberVO;

public interface GetMemberListService {
	List<MemberVO> getAllMemberList();

	List<MemberVO> getMemberList();

	List<DriverVO> getDriverList();

	void expulsionDriver(String id);

	void expulsionMember(String id);

	int getExpulstionMember(String id);

	int getExpulstionDriver(String id);

	void returnMember(String id);

	void returnDriver(String id);

	List<MemberVO> searchMember(String searchOption, String keyword);

	MemberVO getMemberOne(String id);

	void selectMemberAdminSpecify(String id);

	void selectDriverAdminSpecify(String id);
}
