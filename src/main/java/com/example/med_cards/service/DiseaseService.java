package com.example.med_cards.service;

import com.example.med_cards.model.Disease;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;


public interface DiseaseService {
    void save(MultipartFile file);
    Disease findById(String id);
    List<Disease> findAll();
}
