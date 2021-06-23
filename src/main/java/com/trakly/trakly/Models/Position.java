package com.trakly.trakly.Models;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "positions")
public class Position {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @NotNull
    private String name;


    public Position(Long id, @NotNull String name) {
        this.id = id;
        this.name = name;
    }

    public Position() {

    }

    public Long getId() {
        return id;
    }

    public Position setId(Long id) {
        this.id = id;
        return this;
    }

    public String getName() {
        return name;
    }

    public Position setName(String name) {
        this.name = name;
        return this;
    }
}
