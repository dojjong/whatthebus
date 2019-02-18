package what.the.bus.admin.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import what.the.bus.admin.dao.AdminDAO;
import what.the.bus.admin.service.GetMemberListService;
import what.the.bus.member.MemberVO;

@Service
public class GetMemberListServiceImpl implements GetMemberListService{
	
	@Autowired
	private AdminDAO adminDAO;

	@Override
	public List<MemberVO> getMemberList() {
		return adminDAO.getMemberList();
	}
	

}
