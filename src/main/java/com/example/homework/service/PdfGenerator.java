package com.example.homework.service;

import com.example.homework.dtos.PdfObject;
import lombok.extern.slf4j.Slf4j;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPage;
import org.apache.pdfbox.pdmodel.PDPageContentStream;
import org.apache.pdfbox.pdmodel.font.PDFont;
import org.apache.pdfbox.pdmodel.font.PDType1Font;
import org.apache.pdfbox.text.TextPosition;
import org.apache.pdfbox.util.Matrix;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import java.io.IOException;

@Slf4j
public class PdfGenerator {
    PdfObject pdfObject;

    public PdfGenerator(PdfObject pdfObject){
        this.pdfObject = pdfObject;
    }

    private String getTextForPDF(){
        return pdfObject.getName() + "       " + pdfObject.getSurname();
    }

    public void generatePdf() throws IOException {
        PDDocument document = new PDDocument();
        PDPage page = new PDPage();

        document.addPage(page);

        PDPageContentStream contentStream = new PDPageContentStream(document, page);
        contentStream.setFont(PDType1Font.COURIER, 12);
        contentStream.beginText();
        contentStream.moveTo(10, 700);
        contentStream.showText(getTextForPDF());
        contentStream.endText();
        contentStream.close();

        document.save("pdfBoxHelloWorld.pdf");
        document.close();
        log.info("pdf written");
    }


    public void generatePdfDocumentTemplate1() throws IOException {
        PDDocument document = new PDDocument();
        PDPage page = new PDPage();
        document.addPage(page);
        PDFont fontNormal = PDType1Font.HELVETICA;
        PDFont fontBold = PDType1Font.HELVETICA_BOLD;
        PDPageContentStream contentStream =new PDPageContentStream(document, page);
        contentStream.beginText();
        contentStream.newLineAtOffset(0, 700);
        contentStream.setFont(fontBold, 15);
        contentStream.showText("Name: ");
        contentStream.setFont(fontNormal, 15);
        contentStream.showText (pdfObject.getName());
        contentStream.newLineAtOffset(200, 0);
        contentStream.setFont(fontBold, 15);
        contentStream.showText("Surname: ");
        contentStream.setFont(fontNormal, 15);
        contentStream.showText (pdfObject.getSurname());
        contentStream.newLineAtOffset(-200, -50);
        contentStream.setFont(fontBold, 15);
        contentStream.showText("Amount: ");
        contentStream.setFont(fontNormal, 15);
        contentStream.showText (pdfObject.getAmount().toString());
        contentStream.newLineAtOffset(0, -50);
        contentStream.setFont(fontBold, 15);
        contentStream.showText("Fee: ");
        contentStream.setFont(fontNormal, 15);
        contentStream.showText (pdfObject.getFee().toString());
        contentStream.newLineAtOffset(0, -50);
        contentStream.setFont(fontBold, 15);
        contentStream.showText("Period: ");
        contentStream.setFont(fontNormal, 15);
        contentStream.showText (pdfObject.getPeriod().toString());
        contentStream.newLineAtOffset(0, -50);
        contentStream.setFont(fontBold, 15);
        contentStream.showText("Total amount to be paid: ");
        Integer x = pdfObject.getAmount()/pdfObject.getFee()+pdfObject.getAmount();
        contentStream.showText (x.toString());
        contentStream.newLineAtOffset(0, -50);
        contentStream.setFont(fontBold, 15);
        contentStream.showText("Total amount to be paid monthly: ");
        x = x/pdfObject.getPeriod();
        contentStream.showText (x.toString());
        contentStream.setFont(fontNormal, 15);

        contentStream.endText();
        contentStream.close();
        document.save("pdfBoxHelloWorld.pdf");
        log.info("pdf written");
    }
}
