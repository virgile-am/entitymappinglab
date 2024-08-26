package com.entitymappinglab.entitymappinglab.controller;

import com.entitymappinglab.entitymappinglab.entity.Doctor;
import com.entitymappinglab.entitymappinglab.service.DoctorResponse;
import com.entitymappinglab.entitymappinglab.service.HospitalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class HospitalController {

    @Autowired
    private HospitalService hospitalService;


    @PostMapping("/addDoctor")
    public DoctorResponse addDoctor(@RequestBody Doctor doctor) {
        return hospitalService.addDoctorProgrammatically(doctor);
    }

    @GetMapping("/getDoctor/{employeeNumber}")
    public Doctor getDoctor(@PathVariable int employeeNumber) {
        return hospitalService.getDoctorByEmployeeNumber(employeeNumber);
    }

    @DeleteMapping("/deleteDoctor/{employeeNumber}")
    public void deleteDoctor(@PathVariable int employeeNumber) {
        hospitalService.deleteDoctorFromCache(employeeNumber);
    }
}
