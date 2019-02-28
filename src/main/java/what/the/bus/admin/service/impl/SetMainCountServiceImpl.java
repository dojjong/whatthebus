package what.the.bus.admin.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import what.the.bus.admin.dao.AdminDAO;
import what.the.bus.admin.service.SetMainCountService;

@Service
public class SetMainCountServiceImpl implements SetMainCountService {
	@Autowired
	private AdminDAO adminDAO;

	@Override
	public void setMainCount(int mainCount) {
		adminDAO.setMainCount(mainCount);
	}

}
