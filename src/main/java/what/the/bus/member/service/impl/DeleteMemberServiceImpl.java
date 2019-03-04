package what.the.bus.member.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import what.the.bus.member.MemberVO;
import what.the.bus.member.dao.MemberDAO;
import what.the.bus.member.service.DeleteMemberService;
import what.the.bus.util.BCrypt;
import what.the.bus.util.SHA256;

@Service
public class DeleteMemberServiceImpl implements DeleteMemberService {

	@Autowired
	private MemberDAO memberDAO;
	private SHA256 sha = SHA256.getInsatnce();

	@Override
	public void deleteMember(MemberVO vo) {
		memberDAO.deleteMember(vo);
	} 
	
	@Override
	public boolean pwCheckMember(MemberVO vo) {
		// 암호화된 비번 디비랑 비교하는 코드
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
