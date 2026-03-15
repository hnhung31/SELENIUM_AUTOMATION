package models;

import java.io.File;

public class ContactUs {
    private String name;
    private String email;
    private String subject;
    private String message;
    private String uploadFile;

    public ContactUs(String name, String email, String subject, String message, String uploadFile) {
        this.name = name;
        this.email = email;
        this.subject = subject;
        this.message = message;
        this.uploadFile = uploadFile;
    }

    public String getUploadFile() {
        return uploadFile;
    }

    public void setUploadFile(String uploadFile) {
        this.uploadFile = uploadFile;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
