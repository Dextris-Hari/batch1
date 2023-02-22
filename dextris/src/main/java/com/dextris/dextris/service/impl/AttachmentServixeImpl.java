package com.dextris.dextris.service.impl;

import com.dextris.dextris.entity.Attachment;
import com.dextris.dextris.repository.AttachmentRepository;
import com.dextris.dextris.service.AttachmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

@Service
public class AttachmentServixeImpl implements AttachmentService {
    @Autowired
    private AttachmentRepository attachmentRepository;
    public AttachmentServixeImpl( ) {
        System.out.println( this.getClass().getSimpleName());

    }

    public AttachmentServixeImpl(AttachmentRepository attachmentRepository) {
        System.out.println(" inside the para"+ this.getClass().getSimpleName());
        this.attachmentRepository = attachmentRepository;
    }

    @Override
    public Attachment saveAttachment(MultipartFile multipartFile) throws Exception {
        System.out.println(" inside the saveAttachment cus");
        String fileName = StringUtils.cleanPath(multipartFile.getOriginalFilename());
        System.out.println("manoj123");
        try {
            System.out.println("manoj456+");
            if (fileName.contains("..")) {
                System.out.println("manoj789");
                throw new Exception("file name contain invalid path sequence" + fileName);
            }
            System.out.println("manoj");
            Attachment attachment = new Attachment(fileName, multipartFile.getContentType(), multipartFile.getBytes());
            return attachmentRepository.save(attachment);
        } catch (Exception exception) {

            throw new Exception("could not save the file" + fileName);
        }

    }

    @Override
    public Attachment getAttachment(String fileId) throws Exception {
        System.out.println(" inside the getAttachment cus");
        return attachmentRepository.findById(fileId).orElseThrow(() -> new Exception("file not found with id:" + fileId));
    }
}
