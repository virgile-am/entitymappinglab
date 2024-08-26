package com.entitymappinglab.entitymappinglab.service;

import com.entitymappinglab.entitymappinglab.entity.Doctor;
import com.entitymappinglab.entitymappinglab.repository.DoctorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DoctorService {

    @Autowired
    private DoctorRepository doctorRepository;

    public List<Doctor> getAllDoctors() {
        return doctorRepository.findAll();
    }

    public Optional<Doctor> getDoctorById(int id) {
        return doctorRepository.findById(id);
    }

    public Doctor saveDoctor(Doctor doctor) {
        return doctorRepository.save(doctor);
    }

    public void deleteDoctor(int id) {
        doctorRepository.deleteById(id);
    }

    public List<Doctor> getDoctorsBySpecialty(String specialty) {
        return doctorRepository.findBySpecialty(specialty);
    }

    public List<Doctor> getDoctorsByFirstName(String firstName) {
        return doctorRepository.findByFirstName(firstName);
    }

    public List<Doctor> getDoctorsBySurnamePrefix(String prefix) {
        return doctorRepository.findBySurnameStartingWith(prefix);
    }
}
