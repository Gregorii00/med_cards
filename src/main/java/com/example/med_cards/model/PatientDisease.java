package com.example.med_cards.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Data
@Entity
@Table(name = "patient_disease")
public class PatientDisease {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String start_date;
    private String end_date;
    @Column(length=1024)
    private String prescription;
    @ManyToOne
    @JoinColumn(name = "patient_id", referencedColumnName = "id")
    @JsonIgnoreProperties("patientDiseaseList")
    private Patient patient;
    private String disease;
    private String name;


}
