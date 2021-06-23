package com.trakly.trakly.SummaryService.Resource;

public class SummaryResource {
    private Long id;
    private Integer finishedTasks;
    private Integer pendingTasks;
    private Float monthlyAverage;

    public Long getId() {
        return id;
    }

    public SummaryResource setId(Long id) {
        this.id = id;
        return this;
    }

    public Integer getFinishedTasks() {
        return finishedTasks;
    }

    public SummaryResource setFinishedTasks(Integer finishedTasks) {
        this.finishedTasks = finishedTasks;
        return this;
    }

    public Integer getPendingTasks() {
        return pendingTasks;
    }

    public SummaryResource setPendingTasks(Integer pendingTasks) {
        this.pendingTasks = pendingTasks;
        return this;
    }

    public Float getMonthlyAverage() {
        return monthlyAverage;
    }

    public SummaryResource setMonthlyAverage(Float monthlyAverage) {
        this.monthlyAverage = monthlyAverage;
        return this;
    }
}
