package com.example.pdfexport.service;

import com.lowagie.text.*;
import com.lowagie.text.pdf.PRAcroForm;
import com.lowagie.text.pdf.PdfWriter;
import org.springframework.stereotype.Service;

import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Service
public class PDFGeneratorService {


    public  void  export(HttpServletResponse servletResponse) throws IOException {

        Document document=new Document(PageSize.A4);
        // write this document to servletresponse output stream
        PdfWriter.getInstance(document,servletResponse.getOutputStream());
        // open the doccument to write
        document.open();
        // we have a font class to choose a font
        Font titleFont= FontFactory.getFont(FontFactory.HELVETICA_BOLD);

        // set font size
        titleFont.setSize(18);
        // write paragragh
        Paragraph paragraph= new Paragraph("this is title ", titleFont);
        paragraph.setAlignment(Paragraph.ALIGN_CENTER);
         // set font for paragragh data
        Font fontParagragh = FontFactory.getFont(FontFactory.HELVETICA);
        fontParagragh.setSize(12);
        // set font to paragragh
        Paragraph paragraph1= new Paragraph(" this is paragragh.",fontParagragh);
        paragraph1.setAlignment(Paragraph.ALIGN_LEFT);
        document.add(paragraph);
        document.add(paragraph1);
        document.close();


    }
}
