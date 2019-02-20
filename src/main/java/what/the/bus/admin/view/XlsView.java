package what.the.bus.admin.view;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.springframework.web.servlet.view.document.AbstractXlsView;

import what.the.bus.board.BoardVO;

public class XlsView extends AbstractXlsView{

	@Override
	protected void buildExcelDocument(Map<String, Object> model, Workbook workbook, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		

		// change the file name
		response.setHeader("Content-Disposition", "attachment; filename=\"boardList.xls\"");
		
		@SuppressWarnings("unchecked")
		List<BoardVO> boardList = (List<BoardVO>) model.get("board");
		System.out.println("size="+boardList.size());
		// create excel xls sheet
		Sheet sheet = workbook.createSheet("Board Xls");
		
		// create header row
		Row header = sheet.createRow(0);
		header.createCell(0).setCellValue("seq");
		header.createCell(1).setCellValue("title");
		header.createCell(2).setCellValue("name");
		
		// Create data cells
		int rowCount = 1;
		for (BoardVO vo : boardList){
		Row BoardRow = sheet.createRow(rowCount++);
		BoardRow.createCell(0).setCellValue(vo.getSeq());
		BoardRow.createCell(1).setCellValue(vo.getTitle());
		BoardRow.createCell(2).setCellValue(vo.getName());
		}
	}
}
		
	