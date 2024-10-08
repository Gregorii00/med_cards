package com.example.med_cards.service;

import com.example.med_cards.dto.disease.DiseaseDto;
import com.example.med_cards.mapper.disease.DiseaseMapper;
import com.example.med_cards.model.Disease;
import com.example.med_cards.repo.DiseaseRepo;
import com.example.med_cards.scan.CsvUtility;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Service
// кэш
public class DiseaseServiceImpl implements DiseaseService {
    private final DiseaseRepo diseaseRepo;
    private final DiseaseMapper diseaseMapper;

    public DiseaseServiceImpl(DiseaseRepo diseaseRepo, DiseaseMapper diseaseMapper) {
        this.diseaseRepo = diseaseRepo;
        this.diseaseMapper = diseaseMapper;
    }

    @Override
    public void save() {
        try {
            List<Disease> diseaseList = CsvUtility.csvToDiseaseList();
            diseaseRepo.saveAll(diseaseList);
        } catch (IOException ex) {
            throw new RuntimeException("Data is not store successfully: " + ex.getMessage());
        }
    }

    @Override
    @Cacheable("diseases") // инвалидация кэша: чистить кэш по параметру по времени или по новой записи
    // подумать как можно обойти проблему пустого кэша
    public List<DiseaseDto> findAll() {
        List<Disease> diseaseList = diseaseRepo.findAll();
        List<DiseaseDto> diseaseDtoList = new ArrayList<DiseaseDto>();
        for (Disease disease : diseaseList) {
            diseaseDtoList.add(diseaseMapper.toDto(disease));
        }
        return diseaseDtoList;
    }

    @Override
    public DiseaseDto findById(String id) {
        return diseaseMapper.toDto(diseaseRepo.findById(id));
    }
}
