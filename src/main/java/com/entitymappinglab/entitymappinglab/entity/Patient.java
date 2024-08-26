package com.entitymappinglab.entitymappinglab.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.Getter;
import lombok.Setter;

import java.io.Serial;
import java.io.Serializable;
import java.util.Set;

@Getter
@Setter
@Entity
public class Patient implements Serializable {
    @Serial
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int patientNumber;

    private String name;
    private String surname;
    private String address;
    private String telephoneNumber;

    @OneToMany(mappedBy = "patient")
    @JsonBackReference
    private Set<Hospitalization> hospitalizations;
}
