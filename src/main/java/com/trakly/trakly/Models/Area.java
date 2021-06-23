package com.trakly.trakly.Models;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "areas")
public class Area {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @NotNull
    private String name;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "fk_company_id",  nullable = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    private Company company;

    public Area(Long id, @NotNull String name, Company company) {
        this.id = id;
        this.name = name;
        this.company = company;
    }

    public Area() {

    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public Area setName(String name) {
        this.name = name;
        return this;
    }

    public Company getCompany() {
        return company;
    }

    public Area setCompany(Company company) {
        this.company = company;
        return this;
    }
}
