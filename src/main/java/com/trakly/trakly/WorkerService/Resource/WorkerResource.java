package com.trakly.trakly.WorkerService.Resource;


public class WorkerResource {
    private Long id;
    private String name;
    private String lastName;
    private Integer age;
    private String profession;
    private Long phoneNumber;


    public Long getId() {
        return id;
    }

    public WorkerResource setId(Long id) {
        this.id = id;
        return this;
    }

    public String getName() {
        return name;
    }

    public WorkerResource setName(String name) {
        this.name = name;
        return this;
    }

    public String getLastName() {
        return lastName;
    }

    public WorkerResource setLastName(String lastName) {
        this.lastName = lastName;
        return this;
    }

    public Integer getAge() {
        return age;
    }

    public WorkerResource setAge(Integer age) {
        this.age = age;
        return this;
    }

    public String getProfession() {
        return profession;
    }

    public WorkerResource setProfession(String profession) {
        this.profession = profession;
        return this;
    }

    public Long getPhoneNumber() {
        return phoneNumber;
    }

    public WorkerResource setPhoneNumber(Long phoneNumber) {
        this.phoneNumber = phoneNumber;
        return this;
    }
}
