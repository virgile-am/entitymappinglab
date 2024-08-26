package com.entitymappinglab.entitymappinglab.controller;

import com.entitymappinglab.entitymappinglab.entity.*;
import com.entitymappinglab.entitymappinglab.repository.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.util.Arrays;
import java.util.Collections;

import static org.mockito.ArgumentMatchers.any;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@WebMvcTest(HospitalSystemController.class)
class HospitalSystemControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private DepartmentRepository departmentRepository;

    @MockBean
    private DoctorRepository doctorRepository;

    @MockBean
    private NurseRepository nurseRepository;

    @MockBean
    private PatientRepository patientRepository;

    @MockBean
    private WardRepository wardRepository;

    @MockBean
    private HospitalizationRepository hospitalizationRepository;

    private Department department;
    private Doctor doctor;

    @BeforeEach
    void setUp() {
        doctor = new Doctor();
        doctor.setEmployeeNumber(1);
        doctor.setFirstName("John");
        doctor.setSurname("Smith");
        doctor.setSpecialty("Cardiology");

        department = new Department();
        department.setCode("D001");
        department.setName("Cardiology");
        department.setBuilding("A");
        department.setDirector(doctor);
    }

    @Test
    void testGetDepartmentsByBuilding() throws Exception {
        Mockito.when(departmentRepository.findByBuilding("A")).thenReturn(Collections.singletonList(department));

        mockMvc.perform(get("/api/departments/building/A")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[0].code").value("D001"))
                .andExpect(jsonPath("$[0].name").value("Cardiology"));
    }

    @Test
    void testGetDoctorsBySpecialty() throws Exception {
        Mockito.when(doctorRepository.findBySpecialty("Cardiology")).thenReturn(Collections.singletonList(doctor));

        mockMvc.perform(get("/api/doctors/specialty/Cardiology")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[0].firstName").value("John"))
                .andExpect(jsonPath("$[0].surname").value("Smith"));
    }

    @Test
    void testAddDepartment() throws Exception {
        Department newDepartment = new Department();
        newDepartment.setCode("D002");
        newDepartment.setName("Neurology");
        newDepartment.setBuilding("B");

        Mockito.when(departmentRepository.save(any(Department.class))).thenReturn(newDepartment);

        mockMvc.perform(post("/api/departments")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content("{\"code\":\"D002\",\"name\":\"Neurology\",\"building\":\"B\"}"))
                .andExpect(status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.code").value("D002"))
                .andExpect(MockMvcResultMatchers.jsonPath("$.name").value("Neurology"));
    }

    @Test
    void testGetPatientsBySurname() throws Exception {
        Patient patient = new Patient();
        patient.setPatientNumber(1);
        patient.setSurname("Johnson");

        Mockito.when(patientRepository.findBySurname("Johnson")).thenReturn(Collections.singletonList(patient));

        mockMvc.perform(get("/api/patients/surname/Johnson")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[0].patientNumber").value(1))
                .andExpect(jsonPath("$[0].surname").value("Johnson"));
    }

    @Test
    void testAddDoctor() throws Exception {
        Doctor newDoctor = new Doctor();
        newDoctor.setEmployeeNumber(2);
        newDoctor.setFirstName("Jane");
        newDoctor.setSurname("Doe");
        newDoctor.setSpecialty("Neurology");

        Mockito.when(doctorRepository.save(any(Doctor.class))).thenReturn(newDoctor);

        mockMvc.perform(post("/api/doctors")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content("{\"firstName\":\"Jane\",\"surname\":\"Doe\",\"specialty\":\"Neurology\"}"))
                .andExpect(status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.employeeNumber").value(2))
                .andExpect(MockMvcResultMatchers.jsonPath("$.firstName").value("Jane"))
                .andExpect(MockMvcResultMatchers.jsonPath("$.surname").value("Doe"));
    }
}
