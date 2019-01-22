package what.the.bus.member.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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

}
