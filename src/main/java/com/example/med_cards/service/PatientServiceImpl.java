package com.example.med_cards.service;

import com.example.med_cards.model.Patient;
import com.example.med_cards.repo.PatientRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PatientServiceImpl implements PatientService{
    @Autowired
    private PatientRepo patientRepo;
    @Autowired
    private DiseaseService diseaseService;

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
        for (int i = 0; i < patientList.size(); i++) {
            for (int j = 0; j < patientList.get(i).getPatientDiseaseList().size(); j++) {
                patientList.get(i).getPatientDiseaseList().get(j).setDisease_message(diseaseService.findById(patientList.get(i).getPatientDiseaseList().get(j).getDisease()).getName());
            }
        }
        return patientList;
    }
    @Override
    public Patient findById(Long id) {
        Patient patient = patientRepo.findById(id).get();
        for (int j = 0; j < patient.getPatientDiseaseList().size(); j++) {
            patient.getPatientDiseaseList().get(j).setDisease_message(diseaseService.findById(patient.getPatientDiseaseList().get(j).getDisease()).getName());
        }
        return patient;
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
