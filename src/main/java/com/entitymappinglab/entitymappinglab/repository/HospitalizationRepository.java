package com.entitymappinglab.entitymappinglab.repository;

import com.entitymappinglab.entitymappinglab.entity.Hospitalization;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface HospitalizationRepository extends JpaRepository<Hospitalization, Integer> {

    @Cacheable("hospitalizations")
    List<Hospitalization> findByPatientPatientNumber(int patientNumber);

    @Cacheable("hospitalizations")
    List<Hospitalization> findByDoctorEmployeeNumber(int doctorEmployeeNumber);

    @Cacheable("hospitalizations")
    List<Hospitalization> findByDiagnosis(String diagnosis);

    @CacheEvict(value = "hospitalizations", allEntries = true)
    <S extends Hospitalization> S save(S entity);

    @CacheEvict(value = "hospitalizations", allEntries = true)
    void deleteById(Integer id);
}
