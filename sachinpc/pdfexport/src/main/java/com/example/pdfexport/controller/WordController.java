package com.example.pdfexport.controller;

import org.apache.poi.xwpf.usermodel.XWPFDocument;
import org.apache.poi.xwpf.usermodel.XWPFParagraph;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.io.FileInputStream;
import java.io.InputStream;

@RestController
public class WordController {


    @GetMapping("/word")
public String readFile(@RequestParam("file") String file){
try{

    InputStream inputStream= new FileInputStream(file);
    XWPFDocument document= new XWPFDocument(inputStream);
     StringBuilder stringBuilder= new StringBuilder();
     for(XWPFParagraph paragraph:document.getParagraphs()){
         stringBuilder.append(paragraph.getText());
     }
     document.close();
     inputStream.close();
     return stringBuilder.toString();

}
catch (Exception exception){
    exception.getStackTrace();
    return "ERROR";

}



    }





}
