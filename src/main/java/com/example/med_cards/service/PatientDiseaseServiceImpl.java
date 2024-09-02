package com.example.med_cards.service;

import com.example.med_cards.model.PatientDisease;
import com.example.med_cards.repo.PatientDiseaseRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
import java.util.UUID;

@Service
public class PatientDiseaseServiceImpl implements PatientDiseaseService{
    @Autowired
    PatientDiseaseRepo patientDiseaseRepo;
    @Override
    public void save(PatientDisease patientDisease) {
        patientDiseaseRepo.save(patientDisease);
    }
    @Override
    public List<PatientDisease> findAll() {
        return patientDiseaseRepo.findAll();
    }
    @Override
    public void deleteById(UUID id) {
        patientDiseaseRepo.deleteById(id);
    }
    @Override
    public int updatePatientDisease(PatientDisease patientDisease, UUID id){
        PatientDisease patientDisease1 = patientDiseaseRepo.findById(id).get();
        patientDisease1.setStart_date(patientDisease.getStart_date());
        patientDisease1.setEnd_date(patientDisease.getEnd_date());
        patientDisease1.setPrescription(patientDisease.getPrescription());
        patientDisease1.setDisease(patientDisease.getDisease());
        save(patientDisease1);
        return 1;
    }


}