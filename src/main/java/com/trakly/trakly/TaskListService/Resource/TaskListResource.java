package com.trakly.trakly.TaskListService.Resource;

public class TaskListResource {
    private Long id;
    private String name;

    public Long getId() {
        return id;
    }

    public TaskListResource setId(Long id) {
        this.id = id;
        return this;
    }

    public String getName() {
        return name;
    }

    public TaskListResource setName(String name) {
        this.name = name;
        return this;
    }
}
