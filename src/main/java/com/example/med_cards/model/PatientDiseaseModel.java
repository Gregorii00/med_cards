package com.example.med_cards.model;

import lombok.Data;

import java.util.List;

@Data
public class PatientDiseaseModel {
    private String start_date;
    private String end_date;
    private String prescription;
    private String disease;
    private String disease_message;
}
