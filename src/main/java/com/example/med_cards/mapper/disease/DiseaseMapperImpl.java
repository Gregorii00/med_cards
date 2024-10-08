package com.example.med_cards.mapper.disease;

import com.example.med_cards.dto.disease.DiseaseDto;
import com.example.med_cards.model.Disease;
import org.springframework.stereotype.Component;

@Component
public class DiseaseMapperImpl implements DiseaseMapper {
    @Override
    public DiseaseDto toDto(Disease disease){
        if (disease == null){
            return null;
        }
        return DiseaseMapper.INSTANCE.toDto(disease);
    }

    @Override
    public Disease toModel(DiseaseDto diseaseDto) {
        if (diseaseDto == null){
            return null;
        }
        return DiseaseMapper.INSTANCE.toModel(diseaseDto);
    }
}
