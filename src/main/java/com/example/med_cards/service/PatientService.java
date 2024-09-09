package com.example.med_cards.service;

import com.example.med_cards.exception.PatientNotFoundException;
import com.example.med_cards.model.Patient;
import org.springframework.http.ResponseEntity;

import java.util.List;
import java.util.Map;
import java.util.UUID;

public interface PatientService {
    Patient save(Patient patient);
    Map<String, Object> deleteById(UUID id);
//    Patient getById(UUID id) throws PatientNotFoundException;
    ResponseEntity updatePatient(Patient patient, UUID id);
    List <Patient> findPatientList();
    Patient findById(UUID id);
}
