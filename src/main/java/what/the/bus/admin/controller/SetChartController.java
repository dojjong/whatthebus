package what.the.bus.admin.controller;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import what.the.bus.admin.ChartVO1;
import what.the.bus.admin.ChartVO2;
import what.the.bus.admin.ChartVO3;
import what.the.bus.board.BoardVO;
import what.the.bus.board.service.GetBoardListService;
import what.the.bus.booking.BookingPayVO;
import what.the.bus.booking.service.BookingPayService;
import what.the.bus.member.MemberVO;
import what.the.bus.member.service.LoginMemberService;
import what.the.bus.review.service.GetReviewListService;

@Controller
public class SetChartController {
	@Autowired
	private LoginMemberService memberService;
	@Autowired
	private GetBoardListService boardService;
	@Autowired
	private BookingPayService bookingpayService;
	@Autowired
	private GetReviewListService GetReviewListService;

	@RequestMapping("/view/**/getAdminMain.do")
	public String getAdminMain(Model model) {

		return "admin/admin_main";
	}

	@RequestMapping("/view/**/getAdminChartMenu.do")
	public String getAdminChart(Model model) {

		return "admin/admin_chartMenu";
	}

	// 차트1
	@RequestMapping("/view/**/getBoardCountPerRegdateJson.do")
	@ResponseBody
	public List<ChartVO1> getBoardCountPerRegdateJson(Model model, String startdate, String enddate) throws Exception {

		BoardVO vo = new BoardVO();
		vo.setC_startdate(startdate);
		vo.setC_enddate(enddate);
		// System.out.println(startdate + "/" + enddate);

		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
		Date imsi_startdate = (Date) simpleDateFormat.parse(startdate);
		Date imsi_enddate = (Date) simpleDateFormat.parse(enddate);

		List<ChartVO1> list = boardService.getBoardCountPerRegdate(vo);
		// System.out.println(list.size());
		// ChartVO1 cv = new ChartVO1();
		/*
		 * for (int i = 0; i < list.size(); i++) {
		 * System.out.println(list.get(i).getCondition() + " : " +
		 * list.get(i).getCount()); }
		 */

		// 여기서부터는 count가 0인 것들
		ArrayList<String> array = new ArrayList<String>();
		Date currentDate = imsi_startdate;

		while (currentDate.compareTo(imsi_enddate) <= 0) {
			array.add(simpleDateFormat.format(currentDate));
			Calendar c = Calendar.getInstance();
			c.setTime(currentDate);
			c.add(Calendar.DAY_OF_MONTH, 1);
			currentDate = (Date) c.getTime();
		}

		List<ChartVO1> list2 = new ArrayList<ChartVO1>(array.size());

		for (int m = 0; m < array.size(); m++) {
			list2.add(new ChartVO1(array.get(m), 0));
			for (int i = 0; i < list.size(); i++) {
				if (list2.get(m).getDate().trim().toString()
						.equals(list.get(i).getDate().trim().toString())) {
					list2.get(m).setValue(list.get(i).getValue());
					break;
				}
			}
		}
		/*
		 * for (ChartVO1 date : list2) { System.out.println(date.getCondition() + "/" +
		 * date.getCount()); }
		 */

		return list2;
	}

	// 차트2
	@RequestMapping(value = "/view/**/getMemberCountPerRegdateJson.do", produces = "application/json")
	@ResponseBody
	public List<ChartVO2> getMemberCountPerRegdateJson(Model model, String startdate, String enddate) throws Exception {

		MemberVO user = new MemberVO();
		user.setC_startdate(startdate);
		user.setC_enddate(enddate);
		// System.out.println(startdate+"/"+enddate);

		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
		Date imsi_startdate = (Date) simpleDateFormat.parse(startdate);
		Date imsi_enddate = (Date) simpleDateFormat.parse(enddate);

		List<ChartVO1> imsiList = memberService.getMemberCountPerRegdateJson(user);

		ArrayList<String> array = new ArrayList<String>();
		Date currentDate = imsi_startdate;

		while (currentDate.compareTo(imsi_enddate) <= 0) {
			array.add(simpleDateFormat.format(currentDate));
			Calendar c = Calendar.getInstance();
			c.setTime(currentDate);
			c.add(Calendar.DAY_OF_MONTH, 1);
			currentDate = (Date) c.getTime();
		}

		List<ChartVO1> list2 = new ArrayList<ChartVO1>(array.size());

		for (int m = 0; m < array.size(); m++) {
			list2.add(new ChartVO1(array.get(m), 0));
			for (int i = 0; i < imsiList.size(); i++) {
				if (list2.get(m).getDate().trim().toString()
						.equals(imsiList.get(i).getDate().trim().toString())) {
					list2.get(m).setValue(imsiList.get(i).getValue());
					break;
				}
			}
		}

		List<ChartVO2> list = new ArrayList<ChartVO2>();

		ChartVO2 vo = null;
		for (int i = 0; i < list2.size(); i++) {

			Date date1 = (Date) simpleDateFormat.parse(list2.get(i).getDate());

			vo = new ChartVO2(new Date(date1.getTime()), list2.get(i).getValue());

			list.add(vo);
		}
		return list;
	}

	// 차트3
	@RequestMapping("/view/**/getPayPerRegdate.do")
	@ResponseBody
	public List<ChartVO1> getPayPerRegdate(Model model, String startdate, String enddate) throws Exception {

		BookingPayVO vo = new BookingPayVO();
		vo.setC_startdate(startdate);
		vo.setC_enddate(enddate);
		

		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
		Date imsi_startdate = (Date) simpleDateFormat.parse(startdate);
		Date imsi_enddate = (Date) simpleDateFormat.parse(enddate);

		List<ChartVO1> list = bookingpayService.getPayPerRegdate(vo);

		// 여기서부터는 count가 0인 것들
		ArrayList<String> array = new ArrayList<String>();
		Date currentDate = imsi_startdate;

		while (currentDate.compareTo(imsi_enddate) <= 0) {
			array.add(simpleDateFormat.format(currentDate));
			Calendar c = Calendar.getInstance();
			c.setTime(currentDate);
			c.add(Calendar.DAY_OF_MONTH, 1);
			currentDate = (Date) c.getTime();
		}

		List<ChartVO1> list2 = new ArrayList<ChartVO1>(array.size());

		for (int m = 0; m < array.size(); m++) {
			list2.add(new ChartVO1(array.get(m), 0));
			for (int i = 0; i < list.size(); i++) {
				if (list2.get(m).getDate().trim().toString()
						.equals(list.get(i).getDate().trim().toString())) {
					list2.get(m).setValue(list.get(i).getValue());
					break;
				}
			}
		}
		/*
		 * for (ChartVO1 date : list2) { System.out.println(date.getCondition() + "/" +
		 * date.getCount()); }
		 */

		return list2;
	}
	
	
	// 차트4
		@RequestMapping("/view/**/getAvgStarPerDriver.do")
		@ResponseBody
		public List<ChartVO3> getAvgStarPerDriver(Model model) throws Exception {

			List<ChartVO3> list = GetReviewListService.getAvgStarPerDriver();
			System.out.println(list.size());
			System.out.println(list.get(0).getName());
			for(int i=0; i<list.size();i++) {
				System.out.println(list.get(i).getName()+"/"+list.get(i).getPoints());
			}
			return list;
		}
	
	
		
}
