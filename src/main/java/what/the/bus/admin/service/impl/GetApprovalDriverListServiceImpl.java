package what.the.bus.admin.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import what.the.bus.admin.dao.AdminDAO;
import what.the.bus.admin.service.GetApprovalDriverListService;
import what.the.bus.driver.DriverVO;

@Service
public class GetApprovalDriverListServiceImpl implements GetApprovalDriverListService {
	@Autowired
	private AdminDAO adminDAO;

	@Override
	public List<DriverVO> getApprovalDriverList() {
		return adminDAO.getApprovalDriverList();
	}

	@Override
	public void setStateCount(String id) {
		adminDAO.setStateCount(id);
	}
}
