package com.dextris.dextris.entity;

import org.hibernate.annotations.GenericGenerator;
import org.springframework.web.multipart.MultipartFile;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.validation.constraints.Email;

@Entity

public class Attachment {
    @Id
    @GenericGenerator(name = "uuid", strategy = "uuid2")
    @GeneratedValue(generator = "uuid")
    private String id;
    private String fileName;
    private String fileType;
    @Lob
    private byte[] data;

    public Attachment(String fileName, String fileType, byte[] data) {
        System.out.println(" inside para "+this.getClass().getSimpleName());
        this.fileName = fileName;
        this.fileType = fileType;
        this.data = data;
    }

    public Attachment() {
        System.out.println(this.getClass().getSimpleName());
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public String getFileType() {
        return fileType;
    }

    public void setFileType(String fileType) {
        this.fileType = fileType;
    }

    public byte[] getData() {
        return data;
    }

    public void setData(byte[] data) {
        this.data = data;
    }
}
