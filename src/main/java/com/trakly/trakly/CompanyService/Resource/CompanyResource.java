package com.trakly.trakly.CompanyService.Resource;

public class CompanyResource {
    private Long id;
    private String name;

    public Long getId() {
        return id;
    }

    public CompanyResource setId(Long id) {
        this.id = id;
        return this;
    }

    public String getName() {
        return name;
    }

    public CompanyResource setName(String name) {
        this.name = name;
        return this;
    }
}
