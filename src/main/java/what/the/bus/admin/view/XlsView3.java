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

import what.the.bus.admin.ReportVO2;
import what.the.bus.board.BoardVO;

public class XlsView3 extends AbstractXlsView{

	public XlsView3() {
		super();
	}
	public XlsView3(Model inputModel) {
		Model model = inputModel;
	}

	@Override
	protected void buildExcelDocument(Map<String, Object> model, Workbook workbook, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		

		// change the file name
		response.setHeader("Content-Disposition", "attachment; filename=\"boardlist.xls\"");
		
		@SuppressWarnings("unchecked")
		List<BoardVO> boardList = (List<BoardVO>) model.get("list3");
		//System.out.println("size="+afterBoardList.size());
		// create excel xls sheet
		Sheet sheet = workbook.createSheet("boardList");
		
		// create header row
		Row header = sheet.createRow(0);
		header.createCell(0).setCellValue("번호");
		header.createCell(1).setCellValue("제목");
		header.createCell(2).setCellValue("이름");
		header.createCell(3).setCellValue("현재추천수");
		header.createCell(4).setCellValue("목표추천수");
		header.createCell(5).setCellValue("부족한 추천수");
		
		// Create data cells
		int rowCount = 1;
		for (BoardVO vo : boardList){
		Row BoardRow = sheet.createRow(rowCount++);
		BoardRow.createCell(0).setCellValue(String.valueOf(vo.getSeq()));
		BoardRow.createCell(1).setCellValue(vo.getTitle());
		BoardRow.createCell(2).setCellValue(vo.getName());
		BoardRow.createCell(3).setCellValue(String.valueOf(vo.getBest()));
		BoardRow.createCell(4).setCellValue(String.valueOf(vo.getBestgoal()));
		BoardRow.createCell(5).setCellValue(String.valueOf(vo.getBestgoal()-vo.getBest()));
		}
	}
}
		
	