package com.entitymappinglab.entitymappinglab.controller;

import com.entitymappinglab.entitymappinglab.entity.*;
import com.entitymappinglab.entitymappinglab.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class HospitalSystemController {

    @Autowired
    private DepartmentRepository departmentRepository;

    @Autowired
    private DoctorRepository doctorRepository;

    @Autowired
    private NurseRepository nurseRepository;

    @Autowired
    private PatientRepository patientRepository;

    @Autowired
    private WardRepository wardRepository;

    @Autowired
    private HospitalizationRepository hospitalizationRepository;

    // Department Endpoints

    @GetMapping("/departments/building/{building}")
    public List<Department> getDepartmentsByBuilding(@PathVariable String building) {
        return departmentRepository.findByBuilding(building);
    }

    @GetMapping("/departments/director-surname/{surname}")
    public List<Department> getDepartmentsByDirectorSurname(@PathVariable String surname) {
        return departmentRepository.findByDirectorSurname(surname);
    }

    @GetMapping("/departments/name-contains/{keyword}")
    public List<Department> getDepartmentsByNameContaining(@PathVariable String keyword) {
        return departmentRepository.findByNameContaining(keyword);
    }

    @PostMapping("/departments")
    public Department addDepartment(@RequestBody Department department) {
        return departmentRepository.save(department);
    }

    // Doctor Endpoints

    @GetMapping("/doctors/specialty/{specialty}")
    public List<Doctor> getDoctorsBySpecialty(@PathVariable String specialty) {
        return doctorRepository.findBySpecialty(specialty);
    }

    @GetMapping("/doctors/first-name/{firstName}")
    public List<Doctor> getDoctorsByFirstName(@PathVariable String firstName) {
        return doctorRepository.findByFirstName(firstName);
    }

    @GetMapping("/doctors/surname-starts-with/{prefix}")
    public List<Doctor> getDoctorsBySurnameStartingWith(@PathVariable String prefix) {
        return doctorRepository.findBySurnameStartingWith(prefix);
    }

    @PostMapping("/doctors")
    public Doctor addDoctor(@RequestBody Doctor doctor) {
        return doctorRepository.save(doctor);
    }

    // Nurse Endpoints

    @GetMapping("/nurses/department/{departmentCode}")
    public List<Nurse> getNursesByDepartment(@PathVariable String departmentCode) {
        return nurseRepository.findByDepartmentCode(departmentCode);
    }

    @GetMapping("/nurses/rotation/{rotation}")
    public List<Nurse> getNursesByRotation(@PathVariable String rotation) {
        return nurseRepository.findByRotation(rotation);
    }

    @GetMapping("/nurses/salary-greater-than/{salary}")
    public List<Nurse> getNursesBySalaryGreaterThan(@PathVariable float salary) {
        return nurseRepository.findBySalaryGreaterThan(salary);
    }

    @PostMapping("/nurses")
    public Nurse addNurse(@RequestBody Nurse nurse) {
        return nurseRepository.save(nurse);
    }

    // Patient Endpoints

    @GetMapping("/patients/surname/{surname}")
    public List<Patient> getPatientsBySurname(@PathVariable String surname) {
        return patientRepository.findBySurname(surname);
    }

    @GetMapping("/patients/address/{address}")
    public List<Patient> getPatientsByAddress(@PathVariable String address) {
        return patientRepository.findByAddress(address);
    }

    @GetMapping("/patients/telephone/{telephoneNumber}")
    public List<Patient> getPatientsByTelephoneNumber(@PathVariable String telephoneNumber) {
        return patientRepository.findByTelephoneNumber(telephoneNumber);
    }

    @PostMapping("/patients")
    public Patient addPatient(@RequestBody Patient patient) {
        return patientRepository.save(patient);
    }

    // Ward Endpoints

    @GetMapping("/wards/department/{departmentCode}")
    public List<Ward> getWardsByDepartment(@PathVariable String departmentCode) {
        return wardRepository.findByDepartmentCode(departmentCode);
    }

    @GetMapping("/wards/beds-greater-than/{numberOfBeds}")
    public List<Ward> getWardsByNumberOfBedsGreaterThan(@PathVariable int numberOfBeds) {
        return wardRepository.findByNumberOfBedsGreaterThan(numberOfBeds);
    }

    @GetMapping("/wards/supervisor-surname/{surname}")
    public List<Ward> getWardsBySupervisorSurname(@PathVariable String surname) {
        return wardRepository.findBySupervisorSurname(surname);
    }

    @PostMapping("/wards")
    public Ward addWard(@RequestBody Ward ward) {
        return wardRepository.save(ward);
    }

    // Hospitalization Endpoints

    @GetMapping("/hospitalizations/patient/{patientNumber}")
    public List<Hospitalization> getHospitalizationsByPatient(@PathVariable int patientNumber) {
        return hospitalizationRepository.findByPatientPatientNumber(patientNumber);
    }

    @GetMapping("/hospitalizations/doctor/{doctorEmployeeNumber}")
    public List<Hospitalization> getHospitalizationsByDoctor(@PathVariable int doctorEmployeeNumber) {
        return hospitalizationRepository.findByDoctorEmployeeNumber(doctorEmployeeNumber);
    }

    @GetMapping("/hospitalizations/diagnosis/{diagnosis}")
    public List<Hospitalization> getHospitalizationsByDiagnosis(@PathVariable String diagnosis) {
        return hospitalizationRepository.findByDiagnosis(diagnosis);
    }

    @PostMapping("/hospitalizations")
    public Hospitalization addHospitalization(@RequestBody Hospitalization hospitalization) {
        return hospitalizationRepository.save(hospitalization);
    }
}
