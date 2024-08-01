package com.example.med_cards.service;

import com.example.med_cards.model.PatientDisease;

import java.util.List;
import java.util.Map;

public interface PatientDiseaseService {
    void save(PatientDisease patientDisease);
    void deleteById(Long id);
    List<PatientDisease> findAll();
    int deleteByPatientId(Long patientId);

    int updatePatientDisease(String start_date, String end_date, String prescription, String disease, Long id);

}
