package what.the.bus.member.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import what.the.bus.member.MemberVO;
import what.the.bus.member.dao.impl.MemberDAOImpl;
import what.the.bus.member.service.InsertMemberService;
import what.the.bus.util.BCrypt;
import what.the.bus.util.SHA256;

@Service
public class InsertMemberServiceImpl implements InsertMemberService {
	@Autowired
	private MemberDAOImpl memberDAO;
	private SHA256 sha = SHA256.getInsatnce();

	@Override
	public void insertMember(MemberVO vo) {
		// 암호화 변경 코드
		try {
			String shaPass = sha.getSha256(vo.getPassword().getBytes());
			String bcPass = BCrypt.hashpw(shaPass, BCrypt.gensalt());
			vo.setPassword(bcPass);
			memberDAO.insertMember(vo);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public int checkMember(String checkMember) {
		int check = memberDAO.checkMember(checkMember);
		return check;
	}
}
