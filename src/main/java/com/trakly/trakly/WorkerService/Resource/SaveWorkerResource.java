package com.trakly.trakly.WorkerService.Resource;

public class SaveWorkerResource {
    private String name;
    private String lastName;
    private Integer age;
    private String profession;
    private Long phoneNumber;

    public String getName() {
        return name;
    }

    public SaveWorkerResource setName(String name) {
        this.name = name;
        return this;
    }

    public String getLastName() {
        return lastName;
    }

    public SaveWorkerResource setLastName(String lastName) {
        this.lastName = lastName;
        return this;
    }

    public Integer getAge() {
        return age;
    }

    public SaveWorkerResource setAge(Integer age) {
        this.age = age;
        return this;
    }

    public String getProfession() {
        return profession;
    }

    public SaveWorkerResource setProfession(String profession) {
        this.profession = profession;
        return this;
    }

    public Long getPhoneNumber() {
        return phoneNumber;
    }

    public SaveWorkerResource setPhoneNumber(Long phoneNumber) {
        this.phoneNumber = phoneNumber;
        return this;
    }
}
