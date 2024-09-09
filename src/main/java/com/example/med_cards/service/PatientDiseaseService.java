package com.example.med_cards.service;

import com.example.med_cards.model.PatientDisease;
import org.springframework.http.ResponseEntity;

import java.util.List;
import java.util.Map;
import java.util.UUID;

public interface PatientDiseaseService {
    Map<String, Object> deleteById(UUID id);

    PatientDisease save(PatientDisease patientDisease, UUID id);

    List<PatientDisease> findAll();
    ResponseEntity updatePatientDisease(PatientDisease patientDisease, UUID id);

}
