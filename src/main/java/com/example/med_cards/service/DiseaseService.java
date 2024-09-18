package com.example.med_cards.service;

import com.example.med_cards.model.Disease;

import java.util.List;
public interface DiseaseService {
    void save();
    Disease findById(String id);
    List<Disease> findAll();
}
