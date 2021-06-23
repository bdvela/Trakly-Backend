package com.trakly.trakly.Models;

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

    public Summary(Long id, @NotNull Integer finishedTasks, @NotNull Integer pendingTasks, @NotNull Float monthlyAverage) {
        this.id = id;
        this.finishedTasks = finishedTasks;
        this.pendingTasks = pendingTasks;
        this.monthlyAverage = monthlyAverage;
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
}
