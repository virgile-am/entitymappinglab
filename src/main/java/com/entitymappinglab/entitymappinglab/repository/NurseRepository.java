package com.entitymappinglab.entitymappinglab.repository;

import com.entitymappinglab.entitymappinglab.entity.Nurse;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface NurseRepository extends JpaRepository<Nurse, Integer> {


    // Find all nurses by department ID
    List<Nurse> findByDepartmentCode(String departmentCode);

    // Find nurses by rotation schedule
    List<Nurse> findByRotation(String rotation);

    // Find nurses with a salary greater than a specified amount
    List<Nurse> findBySalaryGreaterThan(float salary);
}
