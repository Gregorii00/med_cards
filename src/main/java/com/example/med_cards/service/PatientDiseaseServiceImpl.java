package com.example.med_cards.service;

import com.example.med_cards.model.PatientDisease;
import com.example.med_cards.repo.PatientDiseaseRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

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
        List < PatientDisease > patientDiseaseList = patientDiseaseRepo.findAll();
        for (int i = 0; i<patientDiseaseList.size();i++){
            patientDiseaseList.get(i).setDisease_message(diseaseService.findById(patientDiseaseList.get(i).getDisease()).getName());
        }
        return patientDiseaseList;
    }


    @Override

    public void deleteById(Long id) {

        patientDiseaseRepo.deleteById(id);

    }
    @Override

    public int deleteByPatientId(Long patientId) {

        return patientDiseaseRepo.deleteByPatientId(patientId);

    }

    @Override
    public int updatePatientDisease(String start_date, String end_date, String prescription, String disease, Long id){
        return patientDiseaseRepo.updatePatientDisease(start_date, end_date, prescription, disease, id);
    }
}