package what.the.bus.admin.view;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.ui.Model;
import org.springframework.web.servlet.view.document.AbstractPdfView;

import com.lowagie.text.Document;
import com.lowagie.text.pdf.PdfPTable;
import com.lowagie.text.pdf.PdfWriter;

import what.the.bus.afterBoard.AfterBoardVO;

public class ItextPdfView extends AbstractPdfView{
	
	public ItextPdfView() {
		super();
	}
	public ItextPdfView(Model inputModel) {
		Model model = inputModel;
	}

	@Override
	protected void buildPdfDocument(Map<String, Object> model, Document document, PdfWriter writer,
			HttpServletRequest request, HttpServletResponse response) throws Exception {

		@SuppressWarnings("unchecked")
		List<AfterBoardVO> afterBoardList = (List<AfterBoardVO>) model.get("list");

		PdfPTable table = new PdfPTable(5);
		table.setWidths(new int[] { 20, 100, 50, 50, 50 });

		table.addCell("번호");
		table.addCell("제목");
		table.addCell("작성자");
		table.addCell("등록일");
		table.addCell("조회/추천");

		for (AfterBoardVO vo : afterBoardList) {
			table.addCell(String.valueOf(vo.getSeq()));
			table.addCell(vo.getTitle());
			table.addCell(vo.getName());
			table.addCell(String.valueOf(vo.getRegDate()));
			table.addCell(vo.getCnt()+"/"+vo.getBest());
		}

		document.add(table);
	}

	
}
