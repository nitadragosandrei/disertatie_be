package com.example.homework.service;


import com.example.homework.dtos.PdfObject;
import com.sun.javafx.font.FontFactory;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPage;
import org.apache.pdfbox.pdmodel.PDPageContentStream;
import org.apache.pdfbox.pdmodel.font.PDType1Font;
import org.springframework.stereotype.Service;

import java.awt.*;
import java.io.IOException;

@Service
public class GeneratePdfService {

    public void generatePdf(PdfObject pdfObject) throws IOException {
        PdfGenerator pdfGenerator = new PdfGenerator(pdfObject);
        pdfGenerator.generatePdfDocumentTemplate1();
    }

}
