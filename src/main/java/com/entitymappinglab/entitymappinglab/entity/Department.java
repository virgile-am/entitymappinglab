package com.entitymappinglab.entitymappinglab.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Set;
@Getter
@Setter
@Entity
public class Department {
    @Id
    private String code;
    private String name;
    private String building;

    @OneToOne
    @JoinColumn(name = "director_id")
    private Doctor director;

    @OneToMany(mappedBy = "department")
    private Set<Ward> wards;

}

