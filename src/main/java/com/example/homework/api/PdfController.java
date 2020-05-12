package com.example.homework.api;

import com.example.homework.dtos.PdfObject;
import com.example.homework.service.GeneratePdfService;
import com.example.homework.service.GenerateXMLService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.xml.bind.JAXBException;
import java.io.IOException;

@RestController
@RequestMapping("/api")
public class PdfController {

    @Autowired
    GeneratePdfService pdfService;

    @Autowired
    GenerateXMLService generateXMLService;

    @PostMapping(path = "/uploadFile", consumes=MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity postPdf(@RequestBody PdfObject pdfObject) throws IOException, JAXBException {
        pdfService.generatePdf(pdfObject);
        generateXMLService.generateXmlAndSaveToDb(pdfObject);
        return ResponseEntity.ok("");
    }
}
