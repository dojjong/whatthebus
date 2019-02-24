package what.the.bus.admin.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import what.the.bus.admin.AdminVO;
import what.the.bus.admin.dao.impl.AdminDAOImpl;
import what.the.bus.admin.service.InsertBannerService;

@Service
public class InsertBannerServiceImpl implements InsertBannerService {

	@Autowired
	private AdminDAOImpl adminDAO;

	@Override
	public void insertBanner(AdminVO vo) {
		adminDAO.insertBanner(vo);
	}

	@Override
	public void updateBanner(AdminVO vo) {
		adminDAO.updateBanner(vo);
	}

}
