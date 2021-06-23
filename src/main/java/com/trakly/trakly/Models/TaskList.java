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

    public TaskList(Long id, @NotNull String name) {
        this.id = id;
        this.name = name;
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


}
