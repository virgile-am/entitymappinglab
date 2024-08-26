package com.entitymappinglab.entitymappinglab.service;

import com.entitymappinglab.entitymappinglab.entity.Hospitalization;
import com.entitymappinglab.entitymappinglab.repository.HospitalizationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Service
public class HospitalizationService {

    @Autowired
    private HospitalizationRepository hospitalizationRepository;

    @Transactional(propagation = Propagation.REQUIRES_NEW, isolation = Isolation.SERIALIZABLE)
    public Hospitalization addHospitalization(Hospitalization hospitalization) {
        return hospitalizationRepository.save(hospitalization);
    }
}
