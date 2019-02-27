package what.the.bus.admin.controller;





import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.View;

import what.the.bus.admin.view.ItextPdfView;
import what.the.bus.admin.view.XlsView;
import what.the.bus.admin.view.XlsxView;
import what.the.bus.afterBoard.AfterBoardVO;
import what.the.bus.afterBoard.service.GetAfterBoardListService;

@Controller

public class SetReportController {

	@Autowired
	GetAfterBoardListService getAfterBoardListService;
	
	@RequestMapping("/view/**/getAdminReportMenu.do")
	public String getAdminChart(Model model) {
		
		return "admin/admin_reportMenu";
	}
	
	@RequestMapping(value="/view/**/afterBoardListReport_jsp.do", method=RequestMethod.GET)
    public String afterBoardListReport_jsp(Model model) throws Exception {
    	
        List<AfterBoardVO> list = getAfterBoardListService.getAfterBoardListAll();
		
    	model.addAttribute("list", list);
        return "admin/admin_reportMenu";

    }
	
	@RequestMapping(value="/view/**/afterBoardListReport_xls.do", method=RequestMethod.GET)
    public View afterBoardListReport_xls(Model model) throws Exception {
    	
        List<AfterBoardVO> list = getAfterBoardListService.getAfterBoardListAll();
		
    	model.addAttribute("list", list);
        return new XlsView(model);

    }
	
	@RequestMapping(value="/view/**/afterBoardListReport_xlsx.do", method=RequestMethod.GET)
    public View afterBoardListReport_xlsx(Model model) throws Exception {
    	
		 List<AfterBoardVO> list = getAfterBoardListService.getAfterBoardListAll();
		
    	model.addAttribute("list", list);
        return new XlsxView(model);
    	
    }
	
	@RequestMapping(value="/view/**/afterBoardListReport_pdf.do", method=RequestMethod.GET)
    public View afterBoardListReport_pdf(Model model) throws Exception {
    	
		 List<AfterBoardVO> list = getAfterBoardListService.getAfterBoardListAll();
		
    	model.addAttribute("list", list);
        //return new PDFView(model);
    	return new ItextPdfView(model);
    }
}