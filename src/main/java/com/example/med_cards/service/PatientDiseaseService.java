package com.example.med_cards.service;

import com.example.med_cards.dto.patient_disease.PatientDiseaseDto;
import com.example.med_cards.dto.patient_disease.PatientDiseaseDtoCreate;
import com.example.med_cards.dto.patient_disease.PatientDiseaseDtoView;

import java.util.List;
import java.util.Map;
import java.util.UUID;

public interface PatientDiseaseService {
    Map<String, Object> deleteById(UUID id);

    List<PatientDiseaseDtoView> findAll(UUID id);
    void updatePatientDisease(PatientDiseaseDto patientDiseaseDto, UUID id);

    PatientDiseaseDtoView save(PatientDiseaseDtoCreate patientDiseaseDtoCreate, UUID id);
}
