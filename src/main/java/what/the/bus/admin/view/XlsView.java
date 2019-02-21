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

import what.the.bus.afterBoard.AfterBoardVO;

public class XlsView extends AbstractXlsView{

	public XlsView() {
		super();
	}
	public XlsView(Model inputModel) {
		Model model = inputModel;
	}

	@Override
	protected void buildExcelDocument(Map<String, Object> model, Workbook workbook, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		

		// change the file name
		response.setHeader("Content-Disposition", "attachment; filename=\"afterboardList.xls\"");
		
		@SuppressWarnings("unchecked")
		List<AfterBoardVO> afterBoardList = (List<AfterBoardVO>) model.get("list");
		//System.out.println("size="+afterBoardList.size());
		// create excel xls sheet
		Sheet sheet = workbook.createSheet("AfterBoard Xls");
		
		// create header row
		Row header = sheet.createRow(0);
		header.createCell(0).setCellValue("번호");
		header.createCell(1).setCellValue("제목");
		header.createCell(2).setCellValue("작성자");
		header.createCell(3).setCellValue("등록일");
		header.createCell(4).setCellValue("조회/추천");
		
		// Create data cells
		int rowCount = 1;
		for (AfterBoardVO vo : afterBoardList){
		Row BoardRow = sheet.createRow(rowCount++);
		BoardRow.createCell(0).setCellValue(vo.getSeq());
		BoardRow.createCell(1).setCellValue(vo.getTitle());
		BoardRow.createCell(2).setCellValue(vo.getName());
		BoardRow.createCell(3).setCellValue(vo.getRealregdate());
		BoardRow.createCell(4).setCellValue(vo.getCnt()+"/"+vo.getBest());
		}
	}
}
		
	