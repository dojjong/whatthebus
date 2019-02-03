package what.the.bus.driver.controller;

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

import what.the.bus.driver.DriverVO;
import what.the.bus.driver.service.InsertDriverService;

@Controller
public class InsertDriverController {
	@Autowired
	private InsertDriverService driverService;

	// 회원가입
	@RequestMapping("/view/**/insertDriver.do")
	public String insertDriver(DriverVO vo) throws IOException {

		String resource = "/fileUpload.properties";
		Properties properties = new Properties();

		MultipartFile uploadFile = vo.getUploadFile();
		UUID uuid = UUID.randomUUID();
		try {
			Reader reader = Resources.getResourceAsReader(resource);
			properties.load(reader);
			if (!uploadFile.isEmpty()) {
				String fileName = uuid + "_" + uploadFile.getOriginalFilename();
				uploadFile.transferTo(new File(properties.getProperty("path") + fileName));
				vo.setLicense(properties.getProperty("path") + fileName);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		driverService.insertDriver(vo);
		return "main/main";
	}

}
