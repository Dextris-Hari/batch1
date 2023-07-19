package com.dextris.dextris.service;

import com.dextris.dextris.entity.Attachment;
import org.springframework.web.multipart.MultipartFile;

public interface AttachmentService {
    Attachment saveAttachment(MultipartFile multipartFile) throws Exception;

    Attachment getAttachment(String fileId) throws Exception;
}
