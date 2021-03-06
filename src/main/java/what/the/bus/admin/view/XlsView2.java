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
import what.the.bus.admin.ReportVO2;

public class XlsView2 extends AbstractXlsView{

	public XlsView2() {
		super();
	}
	public XlsView2(Model inputModel) {
		Model model = inputModel;
	}

	@Override
	protected void buildExcelDocument(Map<String, Object> model, Workbook workbook, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		

		// change the file name
		response.setHeader("Content-Disposition", "attachment; filename=\"booklist.xls\"");
		
		@SuppressWarnings("unchecked")
		List<ReportVO2> bookList = (List<ReportVO2>) model.get("list2");
		//System.out.println("size="+afterBoardList.size());
		// create excel xls sheet
		Sheet sheet = workbook.createSheet("bookList");
		
		// create header row
		Row header = sheet.createRow(0);
		header.createCell(0).setCellValue("번호");
		header.createCell(1).setCellValue("상품제목");
		header.createCell(2).setCellValue("이름");
		header.createCell(3).setCellValue("차량");
		header.createCell(4).setCellValue("가격");
		header.createCell(5).setCellValue("상품시작일");
		
		// Create data cells
		int rowCount = 1;
		for (ReportVO2 vo : bookList){
		Row BoardRow = sheet.createRow(rowCount++);
		BoardRow.createCell(0).setCellValue(vo.getNum());
		BoardRow.createCell(1).setCellValue(vo.getTitle());
		BoardRow.createCell(2).setCellValue(vo.getName());
		BoardRow.createCell(3).setCellValue(vo.getBus());
		BoardRow.createCell(4).setCellValue(vo.getPay());
		BoardRow.createCell(5).setCellValue(vo.getRealstartdate());
		}
	}
}
		
	