package com.trakly.trakly.MessageService.Resource;

import com.trakly.trakly.Models.Message;

public class MessageResource {
    private Long id;
    private String subject;
    private String message;

    public Long getId() {
        return id;
    }

    public MessageResource setId(Long id) {
        this.id = id;
        return this;
    }

    public String getSubject() {
        return subject;
    }

    public MessageResource setSubject(String subject) {
        this.subject = subject;
        return this;
    }

    public String getMessage() {
        return message;
    }

    public MessageResource setMessage(String message) {
        this.message = message;
        return this;
    }
}
