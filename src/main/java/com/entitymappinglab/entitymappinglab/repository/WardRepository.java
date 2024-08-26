package com.entitymappinglab.entitymappinglab.repository;

import com.entitymappinglab.entitymappinglab.entity.Ward;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface WardRepository extends JpaRepository<Ward, Integer> {

    // Find wards by department ID
    List<Ward> findByDepartmentCode(String departmentCode);

    // Find wards with a number of beds greater than a specified amount
    List<Ward> findByNumberOfBedsGreaterThan(int numberOfBeds);

    // Find wards by the supervisor's last name
    List<Ward> findBySupervisorSurname(String surname);
}
