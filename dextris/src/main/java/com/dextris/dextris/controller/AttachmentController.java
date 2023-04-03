package com.dextris.dextris.controller;

import com.dextris.dextris.entity.Attachment;
import com.dextris.dextris.model.ResponseData;
import com.dextris.dextris.service.AttachmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.util.List;
import java.util.stream.Collectors;

@RestController
public class AttachmentController {
    @Autowired
    private AttachmentService attachmentService;



    @PostMapping("/upload")
    public ResponseData uploadFile(@RequestParam("file") MultipartFile multipartFile) throws Exception {
        Attachment attachment = null;
        String downloadURL="";
       attachment= attachmentService.saveAttachment(multipartFile);
       downloadURL= ServletUriComponentsBuilder.fromCurrentContextPath().path("/download/").path(attachment.getId()).toUriString();
        System.out.println(downloadURL);
        attachmentService.updateById(downloadURL,attachment.getId());
return  new ResponseData(attachment.getFileName(),downloadURL,multipartFile.getContentType(),multipartFile. getSize());
    }
    @GetMapping("/files/{fileId}")
    public ResponseEntity<Resource> downloadFile(@PathVariable String fileId) throws Exception {
        System.out.println(fileId+"/////////////////////");

Attachment attachment= null;
attachment=attachmentService.getAttachment(fileId);
return ResponseEntity.ok().contentType(MediaType.parseMediaType(attachment.getFileType()))
        .header(HttpHeaders.CONTENT_DISPOSITION,"attachment;filename=\""+attachment.getFileName()+"\"")
        .body(new ByteArrayResource(attachment.getData()));// http://localhost:9900/download/%7BfileId%7D
    }

    @GetMapping("/files")
    public ResponseEntity<List<ResponseData>> getListFiles() {
        List<ResponseData> files = attachmentService.getAll().map(dbFile -> {
            String fileDownloadUri = ServletUriComponentsBuilder
                    .fromCurrentContextPath()
                    .path("/files/")
                    .path(dbFile.getId())
                    .toUriString();

            return new ResponseData(
                    dbFile.getFileName(),
                    fileDownloadUri,
                    dbFile.getFileType(),
                    dbFile.getData().length);
        }).collect(Collectors.toList());

        return ResponseEntity.status(HttpStatus.OK).body(files);
    }
}
