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
import what.the.bus.admin.ReportVO2;
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
		Paragraph p = new Paragraph("상품 목록 리스트", title_font);	
		document.add(p);
		document.add(new Paragraph("\n\n",font));
		@SuppressWarnings("unchecked")
		List<ReportVO2> bookboardList = (List<ReportVO2>) model.get("list2");
		
		PdfPTable table = new PdfPTable(6);
		table.setWidths(new int[] { 20, 80, 50, 50, 50, 50});

		table.addCell(new Paragraph("번호", font));
		table.addCell(new Paragraph("상품제목", font));
		table.addCell(new Paragraph("이름", font));
		table.addCell(new Paragraph("차량", font));
		table.addCell(new Paragraph("가격", font));
		table.addCell(new Paragraph("상품시작일", font));
	
		
		
	
		for (ReportVO2 vo : bookboardList) {
			table.addCell(new Paragraph(String.valueOf(vo.getNum()), font));
			table.addCell(new Paragraph(vo.getTitle(), font));
			table.addCell(new Paragraph(vo.getName(), font));
			table.addCell(new Paragraph(String.valueOf(vo.getBus()), font));
			table.addCell(new Paragraph(String.valueOf(vo.getPay()), font));
			table.addCell(new Paragraph(vo.getRealstartdate(), font));
		}
		

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
