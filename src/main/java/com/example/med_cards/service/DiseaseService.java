package com.example.med_cards.service;

import com.example.med_cards.model.Disease;
import org.springframework.scheduling.annotation.Scheduled;

import java.util.List;
public interface DiseaseService {
    void save();
    Disease findById(String id);
    List<Disease> findAll();
}
