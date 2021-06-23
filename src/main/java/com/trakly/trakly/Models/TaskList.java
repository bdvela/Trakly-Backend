package com.trakly.trakly.Models;

import io.cucumber.java.cy_gb.Ond;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "taskLists")
public class TaskList {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @NotNull
    private String name;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "fk_worker_id")
    @OnDelete(action = OnDeleteAction.CASCADE)
    private Worker worker;

    public TaskList(Long id, @NotNull String name, Worker worker) {
        this.id = id;
        this.name = name;
        this.worker= worker;
    }

    public TaskList() {

    }


    public Long getId() {
        return id;
    }

    public TaskList setId(Long id) {
        this.id = id;
        return this;
    }

    public String getName() {
        return name;
    }

    public TaskList setName(String name) {
        this.name = name;
        return this;
    }
    public Worker getWorker() {
        return worker;
    }

    public TaskList setWorker(Worker worker) {
        this.worker = worker;
        return this;
    }


}
