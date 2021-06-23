package com.trakly.trakly.Models;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Date;

@Entity
@Table(name = "tasks")
public class Task {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @NotNull
    private String description;

    @NotNull
    private String status;

    @NotNull
    private Date startDate;

    @NotNull
    private Date endDate;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "fk_taskList_id",  nullable = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    private TaskList taskList;

    public Task(Long id, @NotNull String description, @NotNull String status, @NotNull Date startDate, @NotNull Date endDate, TaskList taskList) {
        this.id = id;
        this.description = description;
        this.status = status;
        this.startDate = startDate;
        this.endDate = endDate;
        this.taskList = taskList;
    }

    public Task() {

    }


    public Long getId() {
        return id;
    }

    public Task setId(Long id) {
        this.id = id;
        return this;
    }

    public String getDescription() {
        return description;
    }

    public Task setDescription(String description) {
        this.description = description;
        return this;
    }

    public String getStatus() {
        return status;
    }

    public Task setStatus(String status) {
        this.status = status;
        return this;
    }

    public Date getStartDate() {
        return startDate;
    }

    public Task setStartDate(Date startDate) {
        this.startDate = startDate;
        return this;
    }

    public Date getEndDate() {
        return endDate;
    }

    public Task setEndDate(Date endDate) {
        this.endDate = endDate;
        return this;
    }

    public TaskList getTaskList() {
        return taskList;
    }

    public Task setTaskList(TaskList taskList) {
        this.taskList = taskList;
        return this;
    }
}
