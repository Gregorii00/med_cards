package com.example.med_cards.mapper.patient;

import com.example.med_cards.dto.patient.PatientDto;
import com.example.med_cards.dto.patient.PatientDtoCreate;
import com.example.med_cards.dto.patient.PatientDtoView;
import com.example.med_cards.dto.patient_disease.PatientDiseaseDtoView;
import com.example.med_cards.mapper.patientDisease.PatientDiseaseMapper;
import com.example.med_cards.model.Patient;
import com.example.med_cards.model.PatientDisease;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@Mapper(componentModel = "spring", uses = PatientDiseaseMapper.class, imports = {LocalDateTime.class, UUID.class})
public interface PatientMapper {

    PatientMapper INSTANCE = Mappers.getMapper(PatientMapper.class);

    PatientDtoCreate toDtoCreate(Patient patient);

    Patient toModelCreate(PatientDtoCreate patientDtoCreate);

    PatientDtoView toDtoView(Patient patient);

    Patient toModelView(PatientDtoView patientDtoView);

    List<PatientDtoView> toDtoViewList(List<Patient> patientList);
    List<Patient> toModelViewList(List<PatientDtoView> patientDtoViewList);

}
