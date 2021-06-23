package com.trakly.trakly.Models;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;
import org.hibernate.jdbc.Work;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "positions")
public class Position {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @NotNull
    private String name;

    @OneToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "fk_worker_id",nullable = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    private Worker worker;

    public Position(Long id, @NotNull String name) {
        this.id = id;
        this.name = name;
        this.worker = worker;
    }

    public Position() {

    }

    public Long getId() {
        return id;
    }

    public Position setId(Long id) {
        this.id = id;
        return this;
    }

    public String getName() {
        return name;
    }

    public Position setName(String name) {
        this.name = name;
        return this;
    }

    public Worker getWorker() {
        return worker;
    }

    public Position setWorker(Worker worker) {
        this.worker = worker;
        return this;
    }
}
