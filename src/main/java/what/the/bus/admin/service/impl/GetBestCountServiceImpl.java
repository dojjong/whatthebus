package what.the.bus.admin.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import what.the.bus.admin.dao.AdminDAO;
import what.the.bus.admin.service.GetBestCountService;
@Service
public class GetBestCountServiceImpl implements GetBestCountService {
	@Autowired
	private AdminDAO adminDAO;

	@Override
	public int getBestCount() {
		return adminDAO.getBestCount();
	}

}
