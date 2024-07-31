package com.example.med_cards.service;

import com.example.med_cards.model.Patient;
import com.example.med_cards.model.PatientDisease;

import java.util.List;

public interface PatientService {
    void saveAll(List<Patient> patientList);
    void save(Patient patient);
    void deleteById(Long id);

    int updatePatient(String surname, String name, String patronymic, String gender, String birthday, long police_oms, String hireDate, Long id);

    List <Patient> findPatientList();

    Patient getById(Long id);

    Patient findById(Long id);
}
