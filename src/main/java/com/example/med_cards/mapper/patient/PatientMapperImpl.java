package com.example.med_cards.mapper.patient;

import com.example.med_cards.dto.patient.PatientDto;
import com.example.med_cards.dto.patient.PatientDtoCreate;
import com.example.med_cards.dto.patient.PatientDtoView;
import com.example.med_cards.dto.patient_disease.PatientDiseaseDtoView;
import com.example.med_cards.mapper.patientDisease.PatientDiseaseMapper;
import com.example.med_cards.model.Patient;
import com.example.med_cards.model.PatientDisease;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;


@Component
public class PatientMapperImpl implements PatientMapper {


    @Override
    public PatientDtoCreate toDtoCreate(Patient patient) {
        if (patient == null) {
            return null;
        }

        return PatientMapper.INSTANCE.toDtoCreate(patient);
    }

    @Override
    public Patient toModelCreate(PatientDtoCreate patientDtoCreate) {
        if (patientDtoCreate == null) {
            return null;
        }
        return PatientMapper.INSTANCE.toModelCreate(patientDtoCreate);
    }

    @Override
    public PatientDtoView toDtoView(Patient patient) {
        if (patient == null) {
            return null;
        }

        return PatientMapper.INSTANCE.toDtoView(patient);
    }

    @Override
    public Patient toModelView(PatientDtoView patientDtoView) {
        if (patientDtoView == null) {
            return null;
        }
        return PatientMapper.INSTANCE.toModelView(patientDtoView);
    }

    @Override
    public List<Patient> toModelViewList(List<PatientDtoView> patientDtoViewList) {
        if (patientDtoViewList == null){
            return null;
        }
        List<Patient> patientList = new ArrayList<>();
        for (PatientDtoView patientDtoView: patientDtoViewList) {
            patientList.add(PatientMapper.INSTANCE.toModelView(patientDtoView));
        }

        return patientList;
    }

    @Override
    public List<PatientDtoView> toDtoViewList(List<Patient> patientList) {
        if (patientList == null){
            return null;
        }
        List<PatientDtoView> patientDtoViewList = new ArrayList<>();
        for (Patient patient: patientList) {
            patientDtoViewList.add(PatientMapper.INSTANCE.toDtoView(patient));
        }
        return patientDtoViewList;
    }
}
