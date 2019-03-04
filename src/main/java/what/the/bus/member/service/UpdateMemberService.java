package what.the.bus.member.service;

import java.util.List;

import what.the.bus.booking.BookingPayVO;
import what.the.bus.member.MemberVO;

public interface UpdateMemberService {
	void updateMember(MemberVO vo);

	MemberVO getMember(MemberVO vo);

	boolean pwCheckMember(MemberVO vo);

	void pwUpdateMember(MemberVO vo);

	List<BookingPayVO> getMemberPointList(int start, int end, String id);

	int getMemberPointListCount(String id);
}
