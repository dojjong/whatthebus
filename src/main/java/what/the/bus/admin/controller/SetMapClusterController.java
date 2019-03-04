package what.the.bus.admin.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import what.the.bus.bookBoard.service.GetBookBoardListService;

@Controller
public class SetMapClusterController {

	@RequestMapping("/view/**/getStartMapCluster.do")
	public String getAdminChart(Model model) {

		return "admin/admin_mapMenu";
	}
}
