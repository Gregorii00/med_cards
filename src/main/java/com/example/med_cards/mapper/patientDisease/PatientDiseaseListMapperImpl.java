//package com.example.med_cards.mapper.patientDisease;
//
//import com.example.med_cards.dto.patient_disease.PatientDiseaseDto;
//import com.example.med_cards.model.PatientDisease;
//import org.springframework.stereotype.Component;
//
//import java.util.ArrayList;
//import java.util.List;
//
//@Component
//public class PatientDiseaseListMapperImpl implements PatientDiseaseListMapper{
//    private final PatientDiseaseMapper patientDiseaseMapper;
//
//    public PatientDiseaseListMapperImpl(PatientDiseaseMapper patientDiseaseMapper) {
//        this.patientDiseaseMapper = patientDiseaseMapper;
//    }
//
//    @Override
//    public List<PatientDiseaseDto> toDtoList(List<PatientDisease>  patientDiseaseList){
//        if (patientDiseaseList == null){
//            return null;
//        }
//
//        List<PatientDiseaseDto> patientDiseaseDtoList = new ArrayList<>();
//        for (PatientDisease patientDisease: patientDiseaseList
//        ) {
//            patientDiseaseDtoList.add(patientDiseaseMapper.toDto(patientDisease));
//        }
//        return patientDiseaseDtoList;
//    }
//
//    @Override
//    public List<PatientDisease> toModelList(List<PatientDiseaseDto> patientDiseaseDtoList) {
//        if (patientDiseaseDtoList == null) {
//            return null;
//        }
//        List<PatientDisease> patientDiseaseList = new ArrayList<>();
//        for (PatientDiseaseDto patientDiseaseDto: patientDiseaseDtoList
//        ) {
//            patientDiseaseList.add(patientDiseaseMapper.toModel(patientDiseaseDto));
//        }
//        return patientDiseaseList;
//    }
//}
