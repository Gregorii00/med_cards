package com.example.med_cards.service;

import com.example.med_cards.model.Patient;
import com.example.med_cards.repo.PatientDiseaseRepo;
import com.example.med_cards.repo.PatientRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PatientServiceImpl implements PatientService{
    @Autowired

    private PatientRepo patientRepo;
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
        return patientRepo.findAll();
    }
    @Override
    public Patient findById(Long id) {
        return patientRepo.findById(id).get();
    }


    @Override

    public Patient getById(Long id) {

        return patientRepo.findById(id).get();

    }
    @Override
    public void deleteById(Long id) {
        patientRepo.deleteById(id);
    }

    @Override
    public int updatePatient(String surname, String name, String patronymic, String gender, String birthday, long police_oms, String hireDate, Long id){
        return patientRepo.updatePatient(surname, name, patronymic, gender, birthday, police_oms, hireDate, id);
    }


}
