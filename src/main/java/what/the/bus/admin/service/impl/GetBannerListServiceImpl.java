package what.the.bus.admin.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import what.the.bus.admin.AdminVO;
import what.the.bus.admin.dao.AdminDAO;
import what.the.bus.admin.service.GetBannerListService;

@Service
public class GetBannerListServiceImpl implements GetBannerListService{

	@Autowired
	private AdminDAO adminDAO;
	
	@Override
	public List<AdminVO> getBannerList() {
		return adminDAO.getBannerList();
	}
	

}
