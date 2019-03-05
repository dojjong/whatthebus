package what.the.bus.admin.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.View;

import what.the.bus.admin.ReportVO1;
import what.the.bus.admin.view.ItextPdfView;
import what.the.bus.admin.view.ItextPdfView1;
import what.the.bus.admin.view.ItextPdfView2;
import what.the.bus.admin.view.XlsView;
import what.the.bus.admin.view.XlsView1;
import what.the.bus.admin.view.XlsView2;
import what.the.bus.afterBoard.AfterBoardVO;
import what.the.bus.afterBoard.service.GetAfterBoardListService;
import what.the.bus.bookBoard.service.GetBookBoardListService;
import what.the.bus.review.service.GetReviewListService;
import what.the.bus.suggestBoard.SuggestBoardVO;

@Controller

public class SetReportController {

	@Autowired
	GetAfterBoardListService getAfterBoardListService;

	@Autowired
	GetReviewListService GetReviewListService;

	@Autowired
	GetBookBoardListService bookBoardListService;

	@RequestMapping("/view/**/getAdminReportMenu.do")
	public String getAdminReport(Model model) {

		return "admin/admin_reportMenu";
	}

	// 0번 레포트
	@RequestMapping(value = "/view/**/afterBoardListReport_jsp.do", method = RequestMethod.GET)
	public String afterBoardListReport_jsp(Model model) throws Exception {
		List<AfterBoardVO> list = getAfterBoardListService.getAfterBoardListAll();
		model.addAttribute("list", list);
		return "admin/admin_reportMenu";
	}

	@RequestMapping(value = "/view/**/afterBoardListReport_xls.do", method = RequestMethod.GET)
	public View afterBoardListReport_xls(Model model) throws Exception {
		List<AfterBoardVO> list = getAfterBoardListService.getAfterBoardListAll();
		model.addAttribute("list", list);
		return new XlsView(model);

	}

	@RequestMapping(value = "/view/**/afterBoardListReport_pdf.do", method = RequestMethod.GET)
	public View afterBoardListReport_pdf(Model model) throws Exception {
		List<AfterBoardVO> list = getAfterBoardListService.getAfterBoardListAll();
		model.addAttribute("list", list);
		return new ItextPdfView(model);
	}

	// 1번 레포트 - 기사님별 평균별점 후기리스트
	@RequestMapping(value = "/view/**/getReviewListPerDriver.do", method = RequestMethod.GET)
	public Object getReviewListPerDriver_xls(Model model, String view) throws Exception {
		String view2 = "jsp";
		if (view != null) {
			view2 = view;
		}
		System.out.println("컨트롤러 view=" + view);
		
		List<ReportVO1> list = GetReviewListService.getReviewListPerDriver();

		for (int i = 0; i < list.size(); i++) {
			switch (list.get(i).getAvg().substring(0, 0)) {
			case "0":
				list.get(i).setGrade("E");
				break;
			case "1":
				list.get(i).setGrade("D");
				break;
			case "2":
				list.get(i).setGrade("C");
				break;
			case "3":
				list.get(i).setGrade("B");
				break;
			case "4":
				list.get(i).setGrade("A");
				break;
			case "5":
				list.get(i).setGrade("S");
				break;
			}
			switch (list.get(i).getCount() / 30) { // 30건 초과일 경우 ++, 30건 미만이면 --
			case 0:
				list.get(i).setGrade(list.get(i).getGrade() + "--등급");
				break;
			default:
				list.get(i).setGrade(list.get(i).getGrade() + "++등급");
				break;
			}
		}

		for (int i = 0; i < list.size(); i++) {
			list.get(i).toString();
		}

		Map<String, Object> map = new HashMap<String, Object>();
		map.put("list", list);
		map.put("reportname", "1");
		model.addAttribute("map", map);
		
		switch (view2) {
		case "excel":
			System.out.println("excel");
			return new XlsView2(model);
		case "pdf":
			System.out.println("pdf");
			return new ItextPdfView2(model);
		default:
			System.out.println("jsp");
			return "admin/admin_reportMenu";
		}

	}
	
	// 2번 레포트 - 기간별 상품 리스트
		@RequestMapping(value = "/view/**/getBookBoardListReport.do", method = RequestMethod.GET)
		public Object getBookBoardListReport(Model model, String view, String startdate, String enddate) throws Exception {
			System.out.println("param="+startdate+"/"+enddate);
			String view2 = "jsp";
			if (view != null) {
				view2 = view;
			}
			System.out.println("컨트롤러 view=" + view);
			SuggestBoardVO imsiVo = new SuggestBoardVO();
			imsiVo.setC_startdate(startdate);
			imsiVo.setC_enddate(enddate);
			List<SuggestBoardVO> list = bookBoardListService.getBookBoardListReport(imsiVo);

			Map<String, Object> map = new HashMap<String, Object>();
			map.put("list", list);
			map.put("reportname", "2");
			model.addAttribute("map", map);

			switch (view2) {
			case "excel":
				System.out.println("excel");
				return new XlsView2(model);
			case "pdf":
				System.out.println("pdf");
				return new ItextPdfView2(model);
			default:
				System.out.println("jsp");
				return "admin/admin_reportMenu";
			}
		}
}