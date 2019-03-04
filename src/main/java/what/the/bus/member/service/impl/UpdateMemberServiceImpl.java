package what.the.bus.member.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import what.the.bus.booking.BookingPayVO;
import what.the.bus.member.MemberVO;
import what.the.bus.member.dao.impl.MemberDAOImpl;
import what.the.bus.member.service.UpdateMemberService;
import what.the.bus.util.BCrypt;
import what.the.bus.util.SHA256;

@Service
public class UpdateMemberServiceImpl implements UpdateMemberService {
	@Autowired
	private MemberDAOImpl memberDAO;
	private SHA256 sha = SHA256.getInsatnce();

	@Override
	public void updateMember(MemberVO vo) {
		memberDAO.updateMember(vo);
	}

	@Override
	public boolean pwCheckMember(MemberVO vo) {
		// 암호화 비교
		try {
			String shaPass = sha.getSha256(vo.getPassword().getBytes());
			if (BCrypt.checkpw(shaPass, getMember(vo).getPassword())) {
				return true;
			} else {
				return false;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public MemberVO getMember(MemberVO vo) {
		return memberDAO.loginMember(vo);
	}

	@Override
	public void pwUpdateMember(MemberVO vo) {
		// 다시 암호화해서 비번변경
		try {
			String shaPass = sha.getSha256(vo.getPassword().getBytes());
			String bcPass = BCrypt.hashpw(shaPass, BCrypt.gensalt());
			vo.setPassword(bcPass);
			memberDAO.pwUpdateMember(vo);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public List<BookingPayVO> getMemberPointList(int start, int end, String id) {
		return memberDAO.getMemberPointList(start, end, id);
	}

	@Override
	public int getMemberPointListCount(String id) {
		return memberDAO.getMemberPointListCount(id);
	}
}
