//package com.example.med_cards.mapper.patient;
//
//import com.example.med_cards.dto.patient.PatientDto;
//import com.example.med_cards.model.Patient;
//import org.springframework.stereotype.Component;
//
//import java.util.ArrayList;
//import java.util.List;
//
//@Component
//public class PatientListMapperImpl implements PatientListMapper {
//
//
//    private final PatientMapper patientMapper;
//
//    public PatientListMapperImpl(PatientMapper patientMapper) {
//        this.patientMapper = patientMapper;
//    }
//
//    @Override
//    public List<PatientDto> toDtoList(List<Patient>  patientList){
//        if (patientList == null){
//            return null;
//        }
//
//        List<PatientDto> patientDtoList = new ArrayList<>();
//        for (Patient patient: patientList
//             ) {
//            patientDtoList.add(patientMapper.toDto(patient));
//        }
//        return patientDtoList;
//    }
//
//    @Override
//    public List<Patient> toModelList(List<PatientDto> patientDtoList) {
//        if (patientDtoList == null) {
//            return null;
//        }
//        List<Patient> patientList = new ArrayList<>();
//        for (PatientDto patientDto: patientDtoList
//        ) {
//            patientList.add(patientMapper.toModel(patientDto));
//        }
//        return patientList;
//    }
//}
