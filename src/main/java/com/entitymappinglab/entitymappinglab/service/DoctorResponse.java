package com.entitymappinglab.entitymappinglab.service;

import com.entitymappinglab.entitymappinglab.entity.Doctor;
import lombok.Getter;
import lombok.Setter;

import java.io.Serial;
import java.io.Serializable;

@Getter
@Setter
public class DoctorResponse implements Serializable {
    @Serial
    private static final long serialVersionUID = 1L; // Add serialVersionUID for version control

    private Doctor doctor;
    private String message;

    public DoctorResponse(Doctor doctor, String message) {
        this.doctor = doctor;
        this.message = message;
    }
}
