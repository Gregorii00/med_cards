package com.example.med_cards.service;

import com.example.med_cards.model.Patient;
import java.util.List;
import java.util.UUID;

public interface PatientService {
    void saveAll(List<Patient> patientList);
    void save(Patient patient);
    void deleteById(UUID id);
    Patient getById(UUID id);
    int updatePatient(String surname, String name, String patronymic, String gender, String birthday, Long police_oms, String hireDate, UUID id);
    List <Patient> findPatientList();
    Patient findById(UUID id);
}
