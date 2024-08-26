package com.entitymappinglab.entitymappinglab.repository;

import com.entitymappinglab.entitymappinglab.entity.Department;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface DepartmentRepository extends JpaRepository<Department, String> {

    // Find all departments by building name
    List<Department> findByBuilding(String building);

    // Find a department by director's last name
    List<Department> findByDirectorSurname(String surname);

    // Find departments whose name contains a specific keyword
    List<Department> findByNameContaining(String keyword);
}
