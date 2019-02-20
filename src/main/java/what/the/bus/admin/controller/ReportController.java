package what.the.bus.admin.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import what.the.bus.board.BoardVO;
import what.the.bus.board.service.GetBoardListService;

@Controller

public class ReportController {

	@Autowired
	GetBoardListService getBoardListService;
	
	@RequestMapping("/view/**/getAdminReportMenu.do")
	public String getAdminChart(Model model) {
		
		return "admin/admin_reportMenu";
	}
	
	@RequestMapping(value="/view/**/report1.do", method=RequestMethod.GET)
    public String getDocuments(Model model) {
    	
        List<BoardVO> list = getBoardListService.getBoardList(1, 3, "all", "");
		
    	model.addAttribute("list", list);
        return "reports/admin_main";

    }
}