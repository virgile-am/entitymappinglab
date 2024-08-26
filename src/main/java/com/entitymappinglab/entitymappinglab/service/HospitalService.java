package com.entitymappinglab.entitymappinglab.service;

import com.entitymappinglab.entitymappinglab.entity.Doctor;
import com.entitymappinglab.entitymappinglab.repository.DoctorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@EnableCaching
public class HospitalService {

    @Autowired
    private DoctorRepository doctorRepository;

    @Transactional
    public Doctor addDoctorDeclaratively(Doctor doctor) {
        return doctorRepository.save(doctor);
    }

    @Cacheable(value = "doctors", key = "#doctor.employeeNumber")
    @Transactional
    public DoctorResponse addDoctorProgrammatically(Doctor doctor) {
        if ("John".equalsIgnoreCase(doctor.getFirstName())) {
            return new DoctorResponse(null, "  first name John ain't Allowed here");
        }
        Doctor savedDoctor = doctorRepository.save(doctor);
        return new DoctorResponse(savedDoctor, "Doctor added successfully");
    }

    @CacheEvict(value = "doctors", key = "#employeeNumber")
    @Transactional
    public void deleteDoctorFromCache(int employeeNumber) {
    }

    @Cacheable(value = "doctors", key = "#employeeNumber")
    public Doctor getDoctorByEmployeeNumber(int employeeNumber) {
        return doctorRepository.findById(employeeNumber).orElse(null);
    }
}
