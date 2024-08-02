package com.example.med_cards.service;

import com.example.med_cards.model.PatientDisease;

import java.util.List;
import java.util.UUID;

public interface PatientDiseaseService {
    void save(PatientDisease patientDisease);
    void deleteById(UUID id);
    List<PatientDisease> findAll();
    int deleteByPatientId(UUID patientId);

    int updatePatientDisease(String start_date, String end_date, String prescription, String disease, UUID id);

}
