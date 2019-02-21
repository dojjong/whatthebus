package what.the.bus.admin.controller;

import java.io.File;
import java.io.IOException;
import java.io.Reader;
import java.util.Properties;
import java.util.UUID;

import org.apache.ibatis.io.Resources;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;

import what.the.bus.admin.AdminVO;
import what.the.bus.admin.service.InsertBannerService;

@Controller
public class InsertBannerController {

	@Autowired
	private InsertBannerService insertBanner;
	
	@RequestMapping("/view/**/insertBanner.do")
	public String insertBanner(AdminVO vo) throws IOException {

		String resource = "/adminBanner.properties";
		Properties properties = new Properties();

		MultipartFile uploadBanner = vo.getUploadBanner();
		UUID uuid = UUID.randomUUID();
		try {
			Reader reader = Resources.getResourceAsReader(resource);
			properties.load(reader);
			if (!uploadBanner.isEmpty()) {
				String fileName = uuid + "_" + uploadBanner.getOriginalFilename();
				uploadBanner.transferTo(new File(properties.getProperty("path") + fileName));
				vo.setBannername(properties.getProperty("path") + fileName);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		insertBanner.insertBanner(vo);
		return "admin/admin_banner";
	}
}
