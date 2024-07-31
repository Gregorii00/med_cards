package com.example.med_cards.service;

import com.example.med_cards.model.Disease;
import com.example.med_cards.repo.DiseaseRepo;
import com.example.med_cards.scan.CsvUtility;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@Service
public class DiseaseServiceImpl implements DiseaseService{
    @Autowired
    DiseaseRepo diseaseRepo;
    @Override
    public void save(MultipartFile file) {

        try {
            List<Disease> diseaseList = CsvUtility.csvToDiseaseList(file.getInputStream());
            diseaseRepo.saveAll(diseaseList);
        } catch (IOException ex) {
            throw new RuntimeException("Data is not store successfully: " + ex.getMessage());
        }
    }

    @Override
    public List < Disease > findAll() {
        return diseaseRepo.findAll();
    }

    public Disease findById(String id){
        return diseaseRepo.findById(id);
    }
}
