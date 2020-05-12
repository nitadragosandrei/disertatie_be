package com.example.homework.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;

@Data
@NoArgsConstructor
@AllArgsConstructor
@XmlRootElement(name = "pdfObject")
public class PdfObject {
    private String id;
    private String name;
    private String surname;
    private Integer fee;
    private Integer amount;
    private Integer period;
}
