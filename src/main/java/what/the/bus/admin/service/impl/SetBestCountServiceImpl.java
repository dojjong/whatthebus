package what.the.bus.admin.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import what.the.bus.admin.dao.AdminDAO;
import what.the.bus.admin.service.SetBestCountService;

@Service
public class SetBestCountServiceImpl implements SetBestCountService {
	@Autowired
	private AdminDAO adminDAO;

	@Override
	public void setBestCount(int bestCount) {
		adminDAO.setBestCount(bestCount);
	}

}
