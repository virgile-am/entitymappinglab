package com.entitymappinglab.entitymappinglab.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

import java.io.Serial;
import java.io.Serializable;
import java.util.Set;

@Getter
@Setter
@Entity
public class Ward implements Serializable {
    @Serial
    private static final long serialVersionUID = 1L;

    @Id
    private int number;
    private int numberOfBeds;

    @ManyToOne
    @JoinColumn(name = "department_id")
    private Department department;

    @OneToOne
    @JoinColumn(name = "supervisor_id")
    private Nurse supervisor;

    @OneToMany(mappedBy = "ward")
    private Set<Hospitalization> hospitalizations;
}
