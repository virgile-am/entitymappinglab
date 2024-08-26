package com.entitymappinglab.entitymappinglab.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import lombok.Getter;
import lombok.Setter;

import java.io.Serial;
import java.io.Serializable;

@Getter
@Setter
@Entity
public class Nurse extends Employee implements Serializable {
    @Serial
    private static final long serialVersionUID = 1L;

    private String rotation;
    private float salary;

    @ManyToOne
    @JoinColumn(name = "department_id")
    private Department department;

    @OneToOne(mappedBy = "supervisor")
    private Ward ward;
}
