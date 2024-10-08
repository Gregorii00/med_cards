package com.example.med_cards.mapper.patientDisease;

import com.example.med_cards.dto.patient_disease.PatientDiseaseDto;
import com.example.med_cards.dto.patient_disease.PatientDiseaseDtoCreate;
import com.example.med_cards.dto.patient_disease.PatientDiseaseDtoView;
import com.example.med_cards.mapper.disease.DiseaseMapper;
import com.example.med_cards.model.PatientDisease;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@Mapper(componentModel = "spring", imports = {LocalDateTime.class, UUID.class})
public interface PatientDiseaseMapper {

    PatientDiseaseMapper INSTANCE  = Mappers.getMapper(PatientDiseaseMapper.class);
    PatientDisease toModelCreate(PatientDiseaseDtoCreate patientDiseaseDtoCreate);
    PatientDiseaseDtoCreate toDtoCreate(PatientDisease patientDisease);

    PatientDisease toModelView(PatientDiseaseDtoView patientDiseaseDtoView);
    PatientDiseaseDtoView toDtoView(PatientDisease patientDisease);

    List<PatientDiseaseDtoView> toDtoViewList(List<PatientDisease> patientDiseaseList);
    List<PatientDisease> toModelViewList(List<PatientDiseaseDtoView> patientDiseaseDtoList);
}
