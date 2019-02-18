package what.the.bus.admin.service;

import java.util.List;

import what.the.bus.driver.DriverVO;

public interface GetApprovalDriverListService {
	List<DriverVO> getApprovalDriverList();

	void setStateCount(String id);
}
