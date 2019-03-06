package what.the.bus.admin.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.View;

import what.the.bus.admin.ReportVO1;
import what.the.bus.admin.ReportVO2;
import what.the.bus.admin.service.GetBestCountService;
import what.the.bus.admin.view.ItextPdfView;
import what.the.bus.admin.view.ItextPdfView1;
import what.the.bus.admin.view.ItextPdfView2;
import what.the.bus.admin.view.ItextPdfView3;
import what.the.bus.admin.view.XlsView;
import what.the.bus.admin.view.XlsView1;
import what.the.bus.admin.view.XlsView2;
import what.the.bus.admin.view.XlsView3;
import what.the.bus.afterBoard.AfterBoardVO;
import what.the.bus.afterBoard.service.GetAfterBoardListService;
import what.the.bus.board.BoardVO;
import what.the.bus.board.service.GetBoardListService;
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
	
	@Autowired
	GetBoardListService getBoardListService;
	@Autowired
	GetBestCountService getBestCountService;

	@RequestMapping("/view/**/getAdminReportMenu.do")
	public String getAdminReport(Model model) {

		
		return "admin/admin_reportMenu";
	}

	
	// 1번 레포트 - 기사님별 평균별점 후기리스트
	@RequestMapping(value = "/view/**/getReviewListPerDriver.do", method = RequestMethod.GET)
	@ResponseBody
	public Object getReviewListPerDriver(Model model, String view) throws Exception {
		
		String view2 = "jsp";
		if (view != null) {
			view2 = view;
		}
		//System.out.println("view2="+view2);
		List<ReportVO1> list = GetReviewListService.getReviewListPerDriver();

		for (int i = 0; i < list.size(); i++) {
			switch (list.get(i).getAvg().trim().substring(0, 1)) {
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

		model.addAttribute("list1", list);
		
		switch (view2) {
		case "excel":
			//System.out.println("excel");
			return new XlsView1(model);
		case "pdf":
			//System.out.println("pdf");
			return new ItextPdfView1(model);
		default:
			//System.out.println("jsp");
			return list;
		}
	

	}

	
	@RequestMapping(value = "/view/**/getReviewListPerDriver1.do", method = RequestMethod.GET)
	public String getReviewListPerDriver1(Model model) throws Exception {
	
		
		List<ReportVO1> list = GetReviewListService.getReviewListPerDriver();

		for (int i = 0; i < list.size(); i++) {
			switch (list.get(i).getAvg().trim().substring(0, 1)) {
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
		model.addAttribute("list1", list);
		return "admin/admin_reportMenu";

	}
	
	// 2번 레포트 - 기간별 상품 리스트
	@RequestMapping(value = "/view/**/getBookBoardListReport.do", method = RequestMethod.GET)
	@ResponseBody
	public Object getBookBoardListReport(Model model, String view, String startdate, String enddate) throws Exception {
		//System.out.println("param="+startdate+"/"+enddate);
		String view2 = "jsp";
		if (view != null) {
			view2 = view;
		}
		//System.out.println("컨트롤러 view=" + view2);
		SuggestBoardVO imsiVo = new SuggestBoardVO();
		imsiVo.setC_startdate(startdate);
		imsiVo.setC_enddate(enddate);
		//System.out.println(imsiVo.getC_startdate()+"/"+imsiVo.getC_enddate());
		List<ReportVO2> list = bookBoardListService.getBookBoardListReport(imsiVo);

		
		model.addAttribute("list2", list);

		switch (view2) {
			case "excel":
				//System.out.println("excel");
				return new XlsView2(model);
			case "pdf":
				//System.out.println("pdf");
				return new ItextPdfView2(model);
			default:
				//System.out.println("jsp");
				return list;
		}
	}
	
	@RequestMapping(value = "/view/**/getBookBoardListReport1.do", method = RequestMethod.GET)
	public String getBookBoardListReport1(Model model, String startdate, String enddate) throws Exception {
		//System.out.println("param="+startdate+"/"+enddate);
		
		
		SuggestBoardVO imsiVo = new SuggestBoardVO();
		imsiVo.setC_startdate(startdate);
		imsiVo.setC_enddate(enddate);
		//System.out.println(imsiVo.getC_startdate()+"/"+imsiVo.getC_enddate());
		List<ReportVO2> list = bookBoardListService.getBookBoardListReport(imsiVo);

		
		model.addAttribute("list2", list);
		return "admin/admin_reportMenu";
		
	}
	
	// 3번 레포트 - 임박 추천 리스트
	@RequestMapping(value = "/view/**/getHotBoardMove.do", method = RequestMethod.GET)
	@ResponseBody
	public Object getHotBoardMove(Model model, String view) throws Exception {
		
		String view2 = "jsp";
		if (view != null) {
			view2 = view;
		}
		//System.out.println("컨트롤러 view=" + view2);
		BoardVO imsiVo = new BoardVO();
		int bestgoal = getBestCountService.getBestCount();
		imsiVo.setBestgoal(bestgoal);
		
		//System.out.println("목표="+imsiVo.getBestgoal());
		List<BoardVO> list = getBoardListService.getHotBoardMove(imsiVo);

		
		model.addAttribute("list3", list);

		switch (view2) {
			case "excel":
				//System.out.println("excel");
				return new XlsView3(model);
			case "pdf":
				//System.out.println("pdf");
				return new ItextPdfView3(model);
			default:
				//System.out.println("jsp");
				return list;
		}
	}
	
	@RequestMapping(value = "/view/**/getHotBoardMove1.do", method = RequestMethod.GET)
	public Object getHotBoardMove(Model model) throws Exception {
	
		BoardVO imsiVo = new BoardVO();
		int bestgoal = getBestCountService.getBestCount();
		imsiVo.setBestgoal(bestgoal);
		
		//System.out.println("목표="+imsiVo.getBestgoal());
		List<BoardVO> list = getBoardListService.getHotBoardMove(imsiVo);

		
		model.addAttribute("list3", list);

		return "admin/admin_reportMenu";
	}

}