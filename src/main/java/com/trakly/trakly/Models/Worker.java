package com.trakly.trakly.Models;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;
import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "workers")
public class Worker {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @NotNull
    private String name;

    @NotNull
    private String lastName;

    @NotNull
    private Integer age;

    private String profession;

    @NotNull
    private Long phoneNumber;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "fk_area_id")
    @OnDelete(action = OnDeleteAction.CASCADE)
    private Area area;

    public Worker(Long id, @NotNull String name, @NotNull String lastName, @NotNull Integer age, String profession, @NotNull Long phoneNumber, Area area) {
        this.id = id;
        this.name = name;
        this.lastName = lastName;
        this.age = age;
        this.profession = profession;
        this.phoneNumber = phoneNumber;
        this.area = area;
    }

    public Worker() {

    }

    public Long getId() {
        return id;
    }

    public Worker setId(Long id) {
        this.id = id;
        return this;
    }

    public String getName() {
        return name;
    }

    public Worker setName(String name) {
        this.name = name;
        return this;
    }

    public String getLastName() {
        return lastName;
    }

    public Worker setLastName(String lastName) {
        this.lastName = lastName;
        return this;
    }

    public Integer getAge() {
        return age;
    }

    public Worker setAge(Integer age) {
        this.age = age;
        return this;
    }

    public String getProfession() {
        return profession;
    }

    public Worker setProfession(String profession) {
        this.profession = profession;
        return this;
    }

    public Long getPhoneNumber() {
        return phoneNumber;
    }

    public Worker setPhoneNumber(Long phoneNumber) {
        this.phoneNumber = phoneNumber;
        return this;
    }

    public Area getArea() {
        return area;
    }

    public Worker setArea(Area area) {
        this.area = area;
        return this;
    }
}
