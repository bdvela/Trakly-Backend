package com.trakly.trakly.TaskService.Resource;

import com.trakly.trakly.AreaService.Resource.AreaResource;
import com.trakly.trakly.Models.Task;

import java.util.Date;

public class TaskResource {
    private Long id;
    private String description;
    private String status;
    private Date startDate;
    private Date endDate;


    public Long getId() {
        return id;
    }

    public TaskResource setId(Long id) {
        this.id = id;
        return this;
    }

    public String getDescription() {
        return description;
    }

    public TaskResource setDescription(String description) {
        this.description = description;
        return this;
    }

    public String getStatus() {
        return status;
    }

    public TaskResource setStatus(String status) {
        this.status = status;
        return this;
    }

    public Date getStartDate() {
        return startDate;
    }

    public TaskResource setStartDate(Date startDate) {
        this.startDate = startDate;
        return this;
    }

    public Date getEndDate() {
        return endDate;
    }

    public TaskResource setEndDate(Date endDate) {
        this.endDate = endDate;
        return this;
    }
}
