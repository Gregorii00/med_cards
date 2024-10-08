package com.example.med_cards.service;

import com.example.med_cards.dto.patient.PatientDtoCreate;
import com.example.med_cards.dto.patient.PatientDtoView;
import com.example.med_cards.dto.patient.PatientDto;
import com.example.med_cards.dto.patient_disease.PatientDiseaseDtoView;
import com.example.med_cards.mapper.patient.PatientMapper;
import com.example.med_cards.model.Patient;
import com.example.med_cards.model.PatientDisease;
import com.example.med_cards.repo.PatientDiseaseRepo;
import com.example.med_cards.repo.PatientRepo;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.*;

@Service
public class PatientServiceImpl implements PatientService {
    private final PatientRepo patientRepo;
    private final DiseaseService diseaseService;

    private final PatientMapper patientMapper;
    private final PatientDiseaseRepo patientDiseaseRepo;

    public PatientServiceImpl(PatientRepo patientRepo, DiseaseService diseaseService, PatientMapper patientMapper, PatientDiseaseRepo patientDiseaseRepo) {
        this.patientRepo = patientRepo;
        this.diseaseService = diseaseService;
        this.patientMapper = patientMapper;
        this.patientDiseaseRepo = patientDiseaseRepo;
    }

    @Override
    public PatientDtoView save(PatientDtoCreate patientDtoCreate) {
        Patient patient = patientMapper.toModelCreate(patientDtoCreate);
//        patient1.setCreated_at(LocalDateTime.now());
//        patient1.setUpdated_at(LocalDateTime.now());
        Patient patient1 = patientRepo.save(patient);
        return patientMapper.toDtoView(patient1);
    }

    @Override
    public List<PatientDtoView> findPatientList() {
        List<Patient> patientList = patientRepo.findAll();
        List<PatientDtoView> patientDtoList = patientMapper.toDtoViewList(patientList);
//        for (Patient patient : patientList) {
//            List<PatientDisease> patientDiseaseList = patientDiseaseRepo.findAll();
//            List<PatientDiseaseDtoView> patientDiseaseDtoList = new ArrayList<PatientDiseaseDtoView>();
//            for (PatientDisease patientDisease : patientDiseaseList) {
//                if (patient.getId().equals(patientDisease.getPatient().getId())) {
//                    PatientDiseaseDtoView patientDiseaseDtoView = modelMapper.map(patientDisease, PatientDiseaseDtoView.class);
//                    patientDiseaseDtoView.setDiseaseDto(diseaseService.findById(patientDisease.getDisease().getId()));
//                    patientDiseaseDtoList.add(patientDiseaseDtoView);
//                }
//            }
//            PatientDtoView patientDtoView = modelMapper.map(patient, PatientDtoView.class);
//            patientDtoView.setPatientDiseaseDtoViewList(patientDiseaseDtoList);
//            patientDtoList.add(patientDtoView);
//        }
        return patientDtoList;
    }

    @Override
    public Patient findById(UUID id) {
        return patientRepo.findById(id).get();
    }

    @Override
    public Map<String, Object> deleteById(UUID id) {
        Map<String, Object> respPatient = new LinkedHashMap<String, Object>();
        Patient patient1 = patientRepo.findById(id).orElseThrow();
        patientRepo.deleteById(id);// проверка, что нет записи
        respPatient.put("status", 1);
        respPatient.put("data", "Record is deleted successfully!");
        return respPatient;
    }

    @Override
    public void updatePatient(PatientDtoView patientDtoView, UUID id) { // стиль pI
        Patient patient1 = patientRepo.findById(id).orElseThrow();
        patientDtoView.setId(patient1.getId());
        patient1 = patientMapper.toModelView(patientDtoView);
        // библиотека мап стракт
        // переделать через set после findByID

    }
}
