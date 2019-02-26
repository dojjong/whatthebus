package what.the.bus.admin.controller;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import what.the.bus.admin.AdminVO;
import what.the.bus.admin.service.InsertBannerService;

@Controller
public class InsertBannerController {

	@Autowired
	private InsertBannerService insertBanner;

	@RequestMapping("/view/**/insertBanner.do")
	@ResponseBody
	public String insertBanner(AdminVO vo) throws IOException {

		//String resource = "/adminBanner.properties";
		//Properties properties = new Properties();
		System.out.println(vo.toString());

		MultipartFile uploadBannerFile = vo.getUploadBanner();
		//UUID uuid = UUID.randomUUID();
		//try {
			//Reader reader = Resources.getResourceAsReader(resource);
			//properties.load(reader);
			if (!uploadBannerFile.isEmpty()) {
			//	String fileName = uuid + "_" + uploadBannerFile.getOriginalFilename();
				//uploadBannerFile.transferTo(new File(properties.getProperty("path") + fileName));
				//vo.setBannername(properties.getProperty("path") + fileName);
				String fileName = uploadBannerFile.getOriginalFilename();
				vo.setBannername(fileName);
			}
		//} catch (Exception e) {
		//	e.printStackTrace();
		//}
		insertBanner.insertBanner(vo);
		return "success";
	}
	
	@RequestMapping("/view/**/updateBanner.do")
	@ResponseBody
	public String updateBanner(AdminVO vo) throws IOException {
		/*
		String resource = "/adminBanner.properties";
		Properties properties = new Properties();
		

		MultipartFile uploadBannerFile = vo.getUploadBanner();
		UUID uuid = UUID.randomUUID();
		try {
			Reader reader = Resources.getResourceAsReader(resource);
			properties.load(reader);
			if (!uploadBannerFile.isEmpty()) {
				String fileName = uuid + "_" + uploadBannerFile.getOriginalFilename();
				uploadBannerFile.transferTo(new File(properties.getProperty("path") + fileName));
				vo.setBannername(properties.getProperty("path") + fileName);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}*/
		MultipartFile uploadBannerFile = vo.getUploadBanner();
		String fileName = uploadBannerFile.getOriginalFilename();
		vo.setBannername(fileName);
	
		insertBanner.updateBanner(vo);
		
		return "success";
	}
	@RequestMapping("/view/**/deleteBanner.do")
	@ResponseBody
	public String deleteBanner(int seq) {
		insertBanner.deleteBanner(seq);
		return "success";
	}
	
}
