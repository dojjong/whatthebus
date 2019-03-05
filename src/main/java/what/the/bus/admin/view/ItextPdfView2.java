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
import what.the.bus.admin.ReportVO1;
import what.the.bus.suggestBoard.SuggestBoardVO;

public class ItextPdfView2 extends AbstractPdfView {

	public ItextPdfView2() {
		super();
	}

	public ItextPdfView2(Model inputModel) {
		Model model = inputModel;
	}

	@Override
	protected void buildPdfDocument(Map<String, Object> model, Document document, PdfWriter writer,
			HttpServletRequest request, HttpServletResponse response) throws DocumentException, IOException, Exception {
		
		BaseFont bf = null;
		try {
			bf = baseIdentifyFont(ItextPdfView2.class.getClassLoader().getResource("H2GTRE.TTF").getPath());
		}catch(Exception e) {
			e.printStackTrace();
		}
		Font font = new Font(bf, 12);
		Font title_font = new Font(bf, 25);
		Paragraph p = new Paragraph("기사님 별 별점 순위 리스트", title_font);	
		document.add(p);
		document.add(new Paragraph("\n\n",font));
		@SuppressWarnings("unchecked")
		List<SuggestBoardVO> bookboardList = (List<SuggestBoardVO>) model.get("list");
		
		PdfPTable table = new PdfPTable(7);
		table.setWidths(new int[] { 20, 50, 50, 50, 50, 50, 50});

		table.addCell(new Paragraph("번호", font));
		table.addCell(new Paragraph("상품명", font));
		table.addCell(new Paragraph("상품발의자", font));
		table.addCell(new Paragraph("상품등록일", font));
		table.addCell(new Paragraph("차량", font));
		table.addCell(new Paragraph("가격", font));
		table.addCell(new Paragraph("상품시작일", font));
	
		
		
		/*
		for (SuggestBoardVO vo : bookboardList) {
			table.addCell(new Paragraph(String.valueOf(vo.getRank()), font));
			table.addCell(new Paragraph(vo.getDrivername(), font));
			table.addCell(new Paragraph(vo.getAvg(), font));
			table.addCell(new Paragraph(String.valueOf(vo.getCount()), font));
			table.addCell(new Paragraph(vo.getGrade(), font));
		}
		*/

		document.add(table);
	}

	public static BaseFont baseIdentifyFont(String path) throws DocumentException, IOException, Exception {
		if (path == null) {
			return null;
		}
		BaseFont baseFont=null;	
			baseFont = BaseFont.createFont(path, BaseFont.IDENTITY_H, BaseFont.EMBEDDED);
		return baseFont;
	}

}
