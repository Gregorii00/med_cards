package com.example.med_cards.mapper.disease;

import com.example.med_cards.dto.disease.DiseaseDto;
import com.example.med_cards.model.Disease;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface DiseaseMapper {

    DiseaseMapper INSTANCE  = Mappers.getMapper(DiseaseMapper.class);

    DiseaseDto toDto(Disease disease);
    Disease toModel(DiseaseDto diseaseDto);
}
