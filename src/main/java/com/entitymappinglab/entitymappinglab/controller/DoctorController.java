package com.entitymappinglab.entitymappinglab.controller;

import com.entitymappinglab.entitymappinglab.entity.Doctor;
import com.entitymappinglab.entitymappinglab.service.DoctorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/doctors")
public class DoctorController {

    @Autowired
    private DoctorService doctorService;

    @GetMapping
    public List<Doctor> getAllDoctors() {
        return doctorService.getAllDoctors();
    }

    @GetMapping("/{id}")
    public Optional<Doctor> getDoctorById(@PathVariable int id) {
        return doctorService.getDoctorById(id);
    }

    @PostMapping
    public Doctor saveDoctor(@RequestBody Doctor doctor) {
        return doctorService.saveDoctor(doctor);
    }

    @DeleteMapping("/{id}")
    public void deleteDoctor(@PathVariable int id) {
        doctorService.deleteDoctor(id);
    }

    @GetMapping("/specialty/{specialty}")
    public List<Doctor> getDoctorsBySpecialty(@PathVariable String specialty) {
        return doctorService.getDoctorsBySpecialty(specialty);
    }

    @GetMapping("/firstName/{firstName}")
    public List<Doctor> getDoctorsByFirstName(@PathVariable String firstName) {
        return doctorService.getDoctorsByFirstName(firstName);
    }

    @GetMapping("/surnamePrefix/{prefix}")
    public List<Doctor> getDoctorsBySurnamePrefix(@PathVariable String prefix) {
        return doctorService.getDoctorsBySurnamePrefix(prefix);
    }
}
