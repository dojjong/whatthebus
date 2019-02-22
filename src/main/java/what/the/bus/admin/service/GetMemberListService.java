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

}
