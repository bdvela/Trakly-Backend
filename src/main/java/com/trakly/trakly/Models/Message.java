package com.trakly.trakly.Models;

import javax.persistence.*;

@Entity
@Table(name = "messages")
public class Message {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    private String subject;

    private String message;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "fk_sender_id")
    private Worker sender;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "fk_receiver_id")
    private Worker receiver;

    public Message(Long id, String subject, String message, Worker sender, Worker receiver) {
        this.id = id;
        this.subject = subject;
        this.message = message;
        this.sender = sender;
        this.receiver = receiver;
    }

    public Message() {

    }

    public Long getId() {
        return id;
    }

    public Message setId(Long id) {
        this.id = id;
        return this;
    }

    public String getSubject() {
        return subject;
    }

    public Message setSubject(String subject) {
        this.subject = subject;
        return this;
    }

    public String getMessage() {
        return message;
    }

    public Message setMessage(String message) {
        this.message = message;
        return this;
    }

    public Worker getSender() {
        return sender;
    }

    public Message setSender(Worker sender) {
        this.sender = sender;
        return this;
    }

    public Worker getReceiver() {
        return receiver;
    }

    public Message setReceiver(Worker receiver) {
        this.receiver = receiver;
        return this;
    }
}
