package com.example.med_cards.service;

import com.example.med_cards.model.Patient;
import com.example.med_cards.repo.PatientDiseaseRepo;
import com.example.med_cards.repo.PatientRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

@Service
public class PatientServiceImpl implements PatientService{
    @Autowired
    private PatientRepo patientRepo;
    @Autowired
    private DiseaseService diseaseService;
    @Autowired
    private PatientDiseaseRepo patientDiseaseRepo;


    @Override
    public Patient save(Patient patient) {
        Patient patient1 = new Patient(patient);
        return patientRepo.save(patient1);
    }

    @Override
    public List < Patient > findPatientList() {
        return patientRepo.findAll();
    }
    @Override
    public Patient findById(UUID id) {
        Patient patient = patientRepo.findById(id).get();
        return patient;
    }
    @Override
    public Map<String, Object> deleteById(UUID id) {
        Map<String, Object> respPatient = new LinkedHashMap<String, Object>();
        patientRepo.deleteById(id);
        respPatient.put("status", 1);
        respPatient.put("data", "Record is deleted successfully!");
        return respPatient;
    }

    @Override
    public ResponseEntity updatePatient(Patient patient, UUID patient_id){
        Map<String, Object> respPatient = new LinkedHashMap<String, Object>();
        int record  = patientRepo.updatePatient(patient.getSurname(), patient.getName(), patient.getPatronymic(),
                patient.getGender(), patient.getBirthday(), patient.getPolice_oms(), LocalDateTime.now(), patient_id);
        respPatient.put("status", record);
        respPatient.put("data", record+" record is updated.");
        if (record!=0) {
            return new ResponseEntity<>(respPatient, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(respPatient, HttpStatus.NOT_FOUND);
        }
    }
}
