package what.the.bus.member.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import what.the.bus.board.BoardVO;
import what.the.bus.board.ChartVO1;
import what.the.bus.member.MemberVO;
import what.the.bus.member.dao.MemberDAO;
import what.the.bus.member.service.LoginMemberService;
import what.the.bus.suggestBoard.SuggestBoardVO;
import what.the.bus.util.BCrypt;
import what.the.bus.util.SHA256;

@Service
public class LoginMemberServiceImpl implements LoginMemberService {

	@Autowired
	private MemberDAO memberDAO;
	private SHA256 sha = SHA256.getInsatnce();

	@Override
	public boolean loginMember(MemberVO vo) {
		// 암호화된 비번 디비랑 비교하는 코드
		try {
			String shaPass = sha.getSha256(vo.getPassword().getBytes());
			if (BCrypt.checkpw(shaPass, getMember(vo).getPassword())) {
				return true;
			} else {
				return false;
			}
		} catch (Exception e) {

		}
		return false;
	}

	@Override
	public MemberVO getMember(MemberVO vo) {
		return memberDAO.loginMember(vo);
	}

	@Override
	public List<ChartVO1> getMemberCountPerRegdateJson() {
		return memberDAO.getMemberCountPerRegdateJson();
	}

	@Override
	public List<BoardVO> getMyWriteList(int start, int end, String id) {
		return memberDAO.getMyWriteList(start, end, id);
	}

	@Override
	public int getMyWriteListCount(String id) {
		return memberDAO.getMyWriteListCount(id);
	}
	@Override
	public List<SuggestBoardVO> getMyDriveList(int start, int end, String id) {
		return memberDAO.getMyDriveList(start, end, id);
	}

	@Override
	public int getMyDriveListCount(String id) {
		return memberDAO.getMyWriteListCount(id);
	}

}
