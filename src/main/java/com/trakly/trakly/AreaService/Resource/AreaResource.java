package com.trakly.trakly.AreaService.Resource;

import com.trakly.trakly.Models.Area;

public class AreaResource {
    private Long id;
    private String name;


    public Long getId() {
        return id;
    }

    public AreaResource setId(Long id) {
        this.id = id;
        return this;
    }

    public String getName() {
        return name;
    }

    public AreaResource setName(String name) {
        this.name = name;
        return this;
    }
}
