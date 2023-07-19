package com.example.pdfexport.controller;

import com.example.pdfexport.Repository.UserRepository;
import com.example.pdfexport.entity.User;
import com.example.pdfexport.service.PDFGeneratorService;
import com.example.pdfexport.service.UserService;
import com.example.pdfexport.util.UserPDFExporter;
import com.lowagie.text.DocumentException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.PostConstruct;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@RestController
public class PDFController {
    @Autowired
    private PDFGeneratorService pdfGeneratorService;
    @Autowired
    private UserService userService;

    @GetMapping("/pdf")
    public void ecportPDF(HttpServletResponse servletResponse) throws IOException {
        servletResponse.setContentType("application/pdf");
        DateFormat dateFormatter = new SimpleDateFormat("yyyy-MM-dd_HH:mm:ss");
        String currentDateTime = dateFormatter.format(new Date());
        String headerKey = "Content-Disposition";
        String headerValue = "attachment; filename=users_" + currentDateTime + ".pdf";
        servletResponse.setHeader(headerKey, headerValue);
this.pdfGeneratorService.export(servletResponse);

    }
    @GetMapping("/users/export/pdf")
    public void exportToPDF(HttpServletResponse response) throws DocumentException, IOException {
        response.setContentType("application/pdf");
        DateFormat dateFormatter = new SimpleDateFormat("yyyy-MM-dd_HH:mm:ss");
        String currentDateTime = dateFormatter.format(new Date());

        String headerKey = "Content-Disposition";
        String headerValue = "attachment; filename=users_" + currentDateTime + ".pdf";
        response.setHeader(headerKey, headerValue);

        List<User> listUsers = userService.listAll();

        UserPDFExporter exporter = new UserPDFExporter(listUsers);
        exporter.export(response);

    }
    @PostConstruct
    public void initRolesAndUser() {
        System.out.println(" inside the initRolesAndUser cus");

        userService.initRolesAndUser();


    }
}
