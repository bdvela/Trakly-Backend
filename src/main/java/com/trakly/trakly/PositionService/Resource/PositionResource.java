package com.trakly.trakly.PositionService.Resource;

import com.trakly.trakly.Models.Position;
import com.trakly.trakly.PositionService.Service.Implementation.PositionService;

public class PositionResource {
    private Long id;
    private String name;


    public Long getId() {
        return id;
    }

    public PositionResource setId(Long id) {
        this.id = id;
        return this;
    }

    public String getName() {
        return name;
    }

    public PositionResource setName(String name) {
        this.name = name;
        return this;
    }
}
