package com.example.homework.service;

import com.example.homework.bean.XmlBean;
import com.example.homework.dtos.PdfObject;
import com.example.homework.repository.XmlRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.PropertyException;
import java.io.StringWriter;

@Service
public class GenerateXMLService {
    @Autowired
    XmlRepository xmlRepository;

    private String generateXml(PdfObject pdfObject) throws JAXBException {
        JAXBContext jaxbContext = JAXBContext.newInstance(PdfObject.class);

        //Create Marshaller
        Marshaller jaxbMarshaller = jaxbContext.createMarshaller();

        //Required formatting??
        jaxbMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);

        //Print XML String to Console
        StringWriter sw = new StringWriter();

        //Write XML to StringWriter
        jaxbMarshaller.marshal(pdfObject, sw);

        //Verify XML Content
        return sw.toString();
    }

    public void generateXmlAndSaveToDb(PdfObject pdfObject) throws JAXBException {
        String xmlGenerated = generateXml(pdfObject);
        XmlBean xmlBean = XmlBean.builder()
                .id(pdfObject.getId())
                .xmlObject(xmlGenerated)
                .build();
        xmlRepository.save(xmlBean);
    }

}
