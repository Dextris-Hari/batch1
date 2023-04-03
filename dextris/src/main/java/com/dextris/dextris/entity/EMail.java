package com.dextris.dextris.entity;

public class EMail {
    private String toMail;
    private String body;
    private String attachment;
    private String subject;

    public EMail(String toMail, String body, String attachment, String subject) {
        this.toMail = toMail;
        this.body = body;
        this.attachment = attachment;
        this.subject = subject;
    }


    public EMail() {
    }

    public String getToMail() {
        return toMail;
    }

    public void setToMail(String toMail) {
        this.toMail = toMail;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public String getAttachment() {
        return attachment;
    }

    public void setAttachment(String attachment) {
        this.attachment = attachment;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    @Override
    public String toString() {
        return "EMail{" +
                "toMail='" + toMail + '\'' +
                ", body='" + body + '\'' +
                ", attachment='" + attachment + '\'' +
                ", subject='" + subject + '\'' +
                '}';
    }
}
