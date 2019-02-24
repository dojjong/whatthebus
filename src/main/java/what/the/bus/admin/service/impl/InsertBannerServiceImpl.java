package what.the.bus.admin.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import what.the.bus.admin.AdminVO;
import what.the.bus.admin.dao.AdminDAO;
import what.the.bus.admin.service.InsertBannerService;

@Service
public class InsertBannerServiceImpl implements InsertBannerService {

	@Autowired
	private AdminDAO adminDAO;

	@Override
	public void insertBanner(AdminVO vo) {
		adminDAO.insertBanner(vo);
	}

	@Override
	public void updateBanner(AdminVO vo) {
		adminDAO.updateBanner(vo);
	}

	@Override
	public void deleteBanner(int seq) {
		adminDAO.deleteBanner(seq);
	}

}
