package what.the.bus.admin.view;


import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.ui.Model;

import com.itextpdf.io.IOException;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Font;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.BaseFont;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;

import what.the.bus.admin.AbstractPdfView;
import what.the.bus.afterBoard.AfterBoardVO;

public class ItextPdfView extends AbstractPdfView {

	public ItextPdfView() {
		super();
	}

	public ItextPdfView(Model inputModel) {
		Model model = inputModel;
	}

	@Override
	protected void buildPdfDocument(Map<String, Object> model, Document document, PdfWriter writer,
			HttpServletRequest request, HttpServletResponse response) throws DocumentException, IOException, Exception {
		
		BaseFont bf = null;
		try {
			bf = baseIdentifyFont(ItextPdfView.class.getClassLoader().getResource("H2GTRE.TTF").getPath());
		}catch(Exception e) {
			e.printStackTrace();
		}
		Font font = new Font(bf, 12);
		Paragraph paragraph = new Paragraph("안녕하세요", font);

		@SuppressWarnings("unchecked")
		List<AfterBoardVO> afterBoardList = (List<AfterBoardVO>) model.get("list");

		PdfPTable table = new PdfPTable(5);
		table.setWidths(new int[] { 20, 100, 50, 50, 50 });

		table.addCell(new Paragraph("번호", font));
		table.addCell(new Paragraph("제목", font));
		table.addCell(new Paragraph("작성자", font));
		table.addCell(new Paragraph("등록일", font));
		table.addCell(new Paragraph("조회/추천", font));

		for (AfterBoardVO vo : afterBoardList) {
			table.addCell(new Paragraph(String.valueOf(vo.getSeq()), font));
			table.addCell(new Paragraph(vo.getTitle(), font));
			table.addCell(new Paragraph(vo.getName(), font));
			table.addCell(new Paragraph(String.valueOf(vo.getRegDate()), font));
			table.addCell(new Paragraph(vo.getCnt() + "/" + vo.getBest(), font));
		}

		document.add(table);
	}

	public static BaseFont baseIdentifyFont(String path) throws DocumentException, IOException, Exception {
		/*
		String fontPath = ItextPdfView.class.getClassLoader().getResource(path).toExternalForm();
		if (fontPath == null) {
			return null;
		}
		*/

		if (path == null) {
			return null;
		}
		BaseFont baseFont=null;
			
			//baseFont = BaseFont.createFont(fontPath, BaseFont.IDENTITY_H, BaseFont.EMBEDDED);
			baseFont = BaseFont.createFont(path, BaseFont.IDENTITY_H, BaseFont.EMBEDDED);
		
		return baseFont;
	}
	


}
