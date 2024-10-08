package com.example.med_cards.service;

import com.example.med_cards.dto.disease.DiseaseDto;
import com.example.med_cards.model.Disease;

import java.util.List;

public interface DiseaseService {
    void save();

    DiseaseDto findById(String id);

    List<DiseaseDto> findAll();
}
