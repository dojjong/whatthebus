package what.the.bus.admin.view;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.view.document.AbstractPdfView;

import com.lowagie.text.Document;
import com.lowagie.text.pdf.PdfPTable;
import com.lowagie.text.pdf.PdfWriter;

import what.the.bus.board.BoardVO;

public class ItextPdfView extends AbstractPdfView{
	@Override
	protected void buildPdfDocument(Map<String, Object> model, Document document, PdfWriter writer,
			HttpServletRequest request, HttpServletResponse response) throws Exception {

		@SuppressWarnings("unchecked")
		List<BoardVO> boardList = (List<BoardVO>) model.get("board");

		PdfPTable table = new PdfPTable(3);
		table.setWidths(new int[] { 20, 50, 100 });

		table.addCell("No");
		table.addCell("Name");
		table.addCell("Provided by");

		for (BoardVO vo : boardList) {
			table.addCell(String.valueOf(vo.getSeq()));
			table.addCell(vo.getTitle());
			table.addCell(vo.getName());
		}

		document.add(table);
	}

	
}
