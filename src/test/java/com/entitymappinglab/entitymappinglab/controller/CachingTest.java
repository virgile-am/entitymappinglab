package com.entitymappinglab.entitymappinglab.controller;
import com.entitymappinglab.entitymappinglab.entity.Doctor;
import com.entitymappinglab.entitymappinglab.repository.DoctorRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.cache.CacheManager;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
public class CachingTest {

    @Autowired
    private DoctorRepository doctorRepository;

    @Autowired
    private CacheManager cacheManager;

    @Test
    public void testCaching() {
        // Initial call to populate the cache
        List<Doctor> doctors1 = doctorRepository.findBySpecialty("Cardiology");

        // Call again to check if the result comes from the cache
        List<Doctor> doctors2 = doctorRepository.findBySpecialty("Cardiology");

        // Verify that both results are the same (from the cache)
        assertThat(doctors1).isEqualTo(doctors2);

        // Check if the cache contains the result
        assertThat(cacheManager.getCache("doctorsBySpecialty").get("Cardiology")).isNotNull();
    }
}
