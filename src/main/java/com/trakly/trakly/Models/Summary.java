package com.trakly.trakly.Models;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;
import org.hibernate.jdbc.Work;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "summaries")
public class Summary {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @NotNull
    private Integer finishedTasks;

    @NotNull
    private Integer pendingTasks;

    @NotNull
    private Float monthlyAverage;

    @OneToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "fk_worker_id",nullable = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    private Worker worker;

    public Summary(Long id, @NotNull Integer finishedTasks, @NotNull Integer pendingTasks, @NotNull Float monthlyAverage, Worker worker) {
        this.id = id;
        this.finishedTasks = finishedTasks;
        this.pendingTasks = pendingTasks;
        this.monthlyAverage = monthlyAverage;
        this.worker = worker;
    }

    public Summary() {

    }

    public Long getId() {
        return id;
    }

    public Summary setId(Long id) {
        this.id = id;
        return this;
    }

    public Integer getFinishedTasks() {
        return finishedTasks;

    }

    public Summary setFinishedTasks(Integer finishedTasks) {
        this.finishedTasks = finishedTasks;
        return this;
    }

    public Integer getPendingTasks() {
        return pendingTasks;
    }

    public Summary setPendingTasks(Integer pendingTasks) {
        this.pendingTasks = pendingTasks;
        return this;
    }

    public Float getMonthlyAverage() {
        return monthlyAverage;
    }

    public Summary setMonthlyAverage(Float monthlyAverage) {
        this.monthlyAverage = monthlyAverage;
        return this;
    }
    public Worker getWorker() {
        return worker;
    }

    public Summary setWorker(Worker worker) {
        this.worker = worker;
        return this;
    }
}
