package com.trakly.trakly.TaskService.Resource;

import java.util.Date;

public class SaveTaskResource {
    private String description;
    private String status;
    private Date startDate;
    private Date endDate;

    public String getDescription() {
        return description;
    }

    public SaveTaskResource setDescription(String description) {
        this.description = description;
        return this;
    }

    public String getStatus() {
        return status;
    }

    public SaveTaskResource setStatus(String status) {
        this.status = status;
        return this;
    }

    public Date getStartDate() {
        return startDate;
    }

    public SaveTaskResource setStartDate(Date startDate) {
        this.startDate = startDate;
        return this;
    }

    public Date getEndDate() {
        return endDate;
    }

    public SaveTaskResource setEndDate(Date endDate) {
        this.endDate = endDate;
        return this;
    }
}
