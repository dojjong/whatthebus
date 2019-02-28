package what.the.bus.admin.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import what.the.bus.admin.dao.AdminDAO;
import what.the.bus.admin.service.GetMemberListService;
import what.the.bus.driver.DriverVO;
import what.the.bus.member.MemberVO;

@Service
public class GetMemberListServiceImpl implements GetMemberListService {

	@Autowired
	private AdminDAO adminDAO;

	@Override
	public List<MemberVO> getAllMemberList() {
		return adminDAO.getAllMemberList();
	}

	@Override
	public List<MemberVO> getMemberList() {
		return adminDAO.getMemberList();
	}

	@Override
	public List<DriverVO> getDriverList() {
		return adminDAO.getDriverList();
	}

	@Override
	public void expulsionDriver(String id) {
		adminDAO.expulsionDriver(id);
	}

	@Override
	public void expulsionMember(String id) {
		adminDAO.expulsionMember(id);
	}

	@Override
	public int getExpulstionMember(String id) {
		return adminDAO.getExpulstionMember(id);
	}

	@Override
	public int getExpulstionDriver(String id) {
		return adminDAO.getExpulstionDriver(id);
	}

	@Override
	public void returnMember(String id) {
		adminDAO.returnMember(id);
	}

	@Override
	public void returnDriver(String id) {
		adminDAO.returnDriver(id);
	}

	@Override
	public List<MemberVO> searchMember(String searchOption, String keyword) {
		return adminDAO.searchMember(searchOption, keyword);
	}

	@Override
	public MemberVO getMemberOne(String id) {
		return adminDAO.getMemberOne(id);
	}

	@Override
	public void selectMemberAdminSpecify(String id) {
		adminDAO.selectMemberAdminSpecify(id);
	}

	@Override
	public void selectDriverAdminSpecify(String id) {
		adminDAO.selectDriverAdminSpecify(id);
	}

	@Override
	public void insertAdminMemberPoint(int point, String id) {
		int imsi = adminDAO.getMemberPoint(id);
		adminDAO.insertAdminMemberPoint(imsi + point, id);
	}

	@Override
	public void insertAdminDriverPoint(int point, String id) {
		int imsi = adminDAO.getDriverPoint(id);
		adminDAO.insertAdminDriverPoint(imsi + point, id);
	}

	@Override
	public void recoveryAdminMemberPoint(int point, String id) {
		int imsi = adminDAO.getMemberPoint(id) - point;
		if (imsi < 0) {
			imsi = 0;
		}
		adminDAO.insertAdminMemberPoint(imsi, id);
	}

	@Override
	public void recoveryAdminDriverPoint(int point, String id) {
		int imsi = adminDAO.getDriverPoint(id) - point;

		if (imsi < 0) {
			imsi = 0;
		}
		adminDAO.insertAdminDriverPoint(imsi, id);
	}

	@Override
	public int getMemberPoint(String id) {
		return adminDAO.getMemberPoint(id);
	}

	@Override
	public int getDriverPoint(String id) {
		return adminDAO.getDriverPoint(id);
	}
}
