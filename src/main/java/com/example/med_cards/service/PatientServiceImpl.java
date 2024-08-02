package com.example.med_cards.service;

import com.example.med_cards.model.Patient;
import com.example.med_cards.repo.PatientDiseaseRepo;
import com.example.med_cards.repo.PatientRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
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
    public void saveAll(List< Patient > patientList) {
        patientRepo.saveAll(patientList);
    }

    @Override
    public void save(Patient patient) {
        patientRepo.save(patient);
    }

    @Override
    public List < Patient > findPatientList() {
        List <Patient> patientList = patientRepo.findAll();
        patientDiseaseRepo.findAll();
        return patientList;
    }
    @Override
    public Patient findById(UUID id) {
        Patient patient = patientRepo.findById(id).get();
        patientDiseaseRepo.findDiseaseID(id);
        return patient;
    }

    @Override
    public Patient getById(UUID id) {

        return patientRepo.findById(id).get();

    }
    @Override
    public void deleteById(UUID id) {
        patientRepo.deleteById(id);
    }

    @Override
    public int updatePatient(String surname, String name, String patronymic, String gender, String birthday, Long police_oms, String hireDate, UUID id){
        return patientRepo.updatePatient(surname, name, patronymic, gender, birthday, police_oms, hireDate, id);
    }


}
