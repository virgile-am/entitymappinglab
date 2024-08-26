package com.entitymappinglab.entitymappinglab.repository;

import com.entitymappinglab.entitymappinglab.entity.Doctor;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface DoctorRepository extends JpaRepository<Doctor, Integer> {

    @Cacheable(value = "doctors", key = "#specialty")
    List<Doctor> findBySpecialty(String specialty);

    @Cacheable(value = "doctors", key = "#firstName")
    List<Doctor> findByFirstName(String firstName);

    @Cacheable(value = "doctors", key = "#prefix")
    List<Doctor> findBySurnameStartingWith(String prefix);

    @CacheEvict(value = "doctors", allEntries = true)
    <S extends Doctor> S save(S entity);

    @CacheEvict(value = "doctors", allEntries = true)
    void deleteById(Integer id);
}
