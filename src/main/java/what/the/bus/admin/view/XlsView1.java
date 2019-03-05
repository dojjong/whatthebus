package what.the.bus.admin.view;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.springframework.ui.Model;
import org.springframework.web.servlet.view.document.AbstractXlsView;

import what.the.bus.admin.ReportVO1;

public class XlsView1 extends AbstractXlsView{

	public XlsView1() {
		super();
	}
	public XlsView1(Model inputModel) {
		Model model = inputModel;
	}

	@Override
	protected void buildExcelDocument(Map<String, Object> model, Workbook workbook, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		

		// change the file name
		response.setHeader("Content-Disposition", "attachment; filename=\"기사님별평점순위.xls\"");
		
		@SuppressWarnings("unchecked")
		List<ReportVO1> reviewList = (List<ReportVO1>) model.get("list");
		//System.out.println("size="+afterBoardList.size());
		// create excel xls sheet
		Sheet sheet = workbook.createSheet("reviewList");
		
		// create header row
		Row header = sheet.createRow(0);
		header.createCell(0).setCellValue("순위");
		header.createCell(1).setCellValue("기사명");
		header.createCell(2).setCellValue("평균평점");
		header.createCell(3).setCellValue("건수");
		header.createCell(4).setCellValue("등급");
		
		// Create data cells
		int rowCount = 1;
		for (ReportVO1 vo : reviewList){
		Row BoardRow = sheet.createRow(rowCount++);
		BoardRow.createCell(0).setCellValue(vo.getRank());
		BoardRow.createCell(1).setCellValue(vo.getDrivername());
		BoardRow.createCell(2).setCellValue(vo.getAvg());
		BoardRow.createCell(3).setCellValue(vo.getCount());
		BoardRow.createCell(4).setCellValue(vo.getGrade());
		}
	}
}
		
	