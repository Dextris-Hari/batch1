package com.dextris.dextris.service;

import com.dextris.dextris.entity.Attachment;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;
import java.util.stream.Stream;

public interface AttachmentService {
    Attachment saveAttachment(MultipartFile multipartFile) throws Exception;

    Attachment getAttachment(String fileId) throws Exception;
    void  updateById(String URL,String id);

    Stream<Attachment> getAll();
}
