package com.example.med_cards.service;

import com.example.med_cards.model.Patient;
import com.example.med_cards.model.PatientDisease;
import com.example.med_cards.repo.PatientDiseaseRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

@Service
public class PatientDiseaseServiceImpl implements PatientDiseaseService{
    @Autowired
    PatientDiseaseRepo patientDiseaseRepo;
    @Autowired
    PatientService patientService;

    @Override
    public PatientDisease save(PatientDisease patientDisease, UUID id) {
        Patient patient = patientService.findById(id);
        System.out.println(patient);
        patientDisease.setPatient(patient);
        return patientDiseaseRepo.save(patientDisease);
    }
    @Override
    public List<PatientDisease> findAll() {
        return patientDiseaseRepo.findAll();
    }

    @Override
    public Map<String, Object> deleteById(UUID id) {
        Map<String, Object> respPatientDisease = new LinkedHashMap<String, Object>();
        patientDiseaseRepo.deleteById(id);
        respPatientDisease.put("status", 1);
        respPatientDisease.put("data", "Record is deleted successfully!");
        return respPatientDisease;
    }
    @Override
    public ResponseEntity updatePatientDisease(PatientDisease patientDisease, UUID id){
        Map<String, Object> respPatientDisease = new LinkedHashMap<String, Object>();
        PatientDisease patientDisease1 = patientDiseaseRepo.findById(id).get();
        patientDisease1.setStart_date(patientDisease.getStart_date());
        patientDisease1.setEnd_date(patientDisease.getEnd_date());
        patientDisease1.setPrescription(patientDisease.getPrescription());
        patientDisease1.setDisease(patientDisease.getDisease());
        patientDiseaseRepo.save(patientDisease1);
        PatientDisease patientDisease2 = patientDiseaseRepo.findById(id).get();
        int record =0;
        if(patientDisease2.equals(patientDisease1)){
            record = 1;
        }
        respPatientDisease.put("status", record);
        respPatientDisease.put("data", record+" record is updated.");
        if (record!=0) {
            return new ResponseEntity<>(respPatientDisease, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(respPatientDisease, HttpStatus.NOT_FOUND);
        }
    }
}