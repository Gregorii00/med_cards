package com.example.med_cards.service;

import com.example.med_cards.model.PatientDisease;
import com.example.med_cards.repo.PatientDiseaseRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.UUID;

@Service
public class PatientDiseaseServiceImpl implements PatientDiseaseService{
    @Autowired
    PatientDiseaseRepo patientDiseaseRepo;
    @Autowired
    private DiseaseService diseaseService;

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

    public int deleteByPatientId(UUID patientId) {

        return patientDiseaseRepo.deleteByPatientId(patientId);

    }

    @Override
    public int updatePatientDisease(String start_date, String end_date, String prescription, String disease, UUID id){
        return patientDiseaseRepo.updatePatientDisease(start_date, end_date, prescription, disease, id);
    }
}