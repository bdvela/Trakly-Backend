package com.trakly.trakly.MessageService.Resource;

public class SaveMessageResource {
    private String subject;
    private String message;


    public String getSubject() {
        return subject;
    }

    public SaveMessageResource setSubject(String subject) {
        this.subject = subject;
        return this;
    }

    public String getMessage() {
        return message;
    }

    public SaveMessageResource setMessage(String message) {
        this.message = message;
        return this;
    }
}
