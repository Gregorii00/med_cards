package com.example.med_cards.service;

import com.example.med_cards.dto.patient_disease.PatientDiseaseDto;
import com.example.med_cards.dto.patient_disease.PatientDiseaseDtoCreate;
import com.example.med_cards.dto.patient_disease.PatientDiseaseDtoView;
import com.example.med_cards.mapper.patientDisease.PatientDiseaseMapper;
import com.example.med_cards.model.Patient;
import com.example.med_cards.model.PatientDisease;
import com.example.med_cards.repo.PatientDiseaseRepo;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class PatientDiseaseServiceImpl implements PatientDiseaseService {
    private final PatientDiseaseRepo patientDiseaseRepo;
    private final DiseaseService diseaseService;
    private final PatientService patientService;
    private final PatientDiseaseMapper patientDiseaseMapper;


    public PatientDiseaseServiceImpl(PatientDiseaseRepo patientDiseaseRepo, DiseaseService diseaseService, PatientService patientService, PatientDiseaseMapper patientDiseaseMapper) {
        this.patientDiseaseRepo = patientDiseaseRepo;
        this.diseaseService = diseaseService;
        this.patientService = patientService;
        this.patientDiseaseMapper = patientDiseaseMapper;
    }

    @Override
    public PatientDiseaseDtoView save(PatientDiseaseDtoCreate patientDiseaseDtoCreate, UUID id) {
        Patient patient = patientService.findById(id);
        PatientDisease patientDisease = patientDiseaseMapper.toModelCreate(patientDiseaseDtoCreate);
        patientDisease.setPatient(patient);
        patient.addDisease(patientDisease);
        PatientDisease patientDiseaseSave = patientDiseaseRepo.save(patientDisease);
        PatientDiseaseDtoView patientDiseaseDtoView = patientDiseaseMapper.toDtoView(patientDiseaseSave);
        return patientDiseaseDtoView;
    }

    @Override
    public List<PatientDiseaseDtoView> findAll(UUID patientId) {
        List<PatientDisease> patientDiseaseList = patientDiseaseRepo.findAll();
//        List<PatientDiseaseDtoView> patientDiseaseDtoList = patientDiseaseMapper.toDtoViewList(patientDiseaseList);
//        for (PatientDisease patientDisease : patientDiseaseList) {
//            if (patientId.equals(patientDisease.getPatient().getId())) {
//                PatientDiseaseDtoView patientDiseaseDtoView = patientDiseaseMapper.toDtoView(patientDisease);
//                patientDiseaseDtoList.add(patientDiseaseDtoView);
//            }
//        }
        return patientDiseaseMapper.toDtoViewList(patientDiseaseList);
    }

    @Override
    public Map<String, Object> deleteById(UUID id) {
        Map<String, Object> respPatientDisease = new LinkedHashMap<String, Object>();
        patientDiseaseRepo.deleteById(id);
        respPatientDisease.put("status", 1);
        respPatientDisease.put("data", "Record is deleted successfully!"); // перекинуть ошибку и выводить через отдельный класс в контроллере
        return respPatientDisease;
    }

    @Override
    public void updatePatientDisease(PatientDiseaseDto patientDiseaseDto, UUID id) {
        PatientDiseaseDtoView patientDiseaseDto1 = patientDiseaseMapper.toDtoView(patientDiseaseRepo.findById(id).orElseThrow());  // проверку на наличие записи, и обработка чтобы не было 500
        patientDiseaseDto1.setStartDate(patientDiseaseDto.getStartDate());
        patientDiseaseDto1.setEndDate(patientDiseaseDto.getEndDate());
        patientDiseaseDto1.setPrescription(patientDiseaseDto.getPrescription());
        patientDiseaseDto1.setDiseaseDto(patientDiseaseDto.getDiseaseDto());
    }
}