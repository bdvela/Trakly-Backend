package com.trakly.trakly.SummaryService.Resource;

public class SaveSummaryResource {
    private Integer finishedTasks;
    private Integer pendingTasks;
    private Float monthlyAverage;

    public Integer getFinishedTasks() {
        return finishedTasks;
    }

    public SaveSummaryResource setFinishedTasks(Integer finishedTasks) {
        this.finishedTasks = finishedTasks;
        return this;
    }

    public Integer getPendingTasks() {
        return pendingTasks;
    }

    public SaveSummaryResource setPendingTasks(Integer pendingTasks) {
        this.pendingTasks = pendingTasks;
        return this;
    }

    public Float getMonthlyAverage() {
        return monthlyAverage;
    }

    public SaveSummaryResource setMonthlyAverage(Float monthlyAverage) {
        this.monthlyAverage = monthlyAverage;
        return this;
    }
}
