package com.example.med_cards.service;

import com.example.med_cards.dto.patient.PatientDto;
import com.example.med_cards.dto.patient.PatientDtoCreate;
import com.example.med_cards.dto.patient.PatientDtoView;
import com.example.med_cards.model.Patient;

import java.util.List;
import java.util.Map;
import java.util.UUID;

public interface PatientService {
    Map<String, Object> deleteById(UUID id);
    List<PatientDtoView> findPatientList();
    Patient findById(UUID id);

    PatientDtoView save(PatientDtoCreate patientDtoCreate);

    void updatePatient(PatientDtoView patientDtoView, UUID id);
}
