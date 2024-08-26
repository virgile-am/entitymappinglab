package com.entitymappinglab.entitymappinglab.repository;

import com.entitymappinglab.entitymappinglab.entity.Patient;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PatientRepository extends JpaRepository<Patient, Integer> {

    // Find patients by surname
    List<Patient> findBySurname(String surname);

    // Find patients by address
    List<Patient> findByAddress(String address);

    // Find patients by telephone number
    List<Patient> findByTelephoneNumber(String telephoneNumber);
}
