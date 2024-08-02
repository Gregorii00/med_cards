package com.example.med_cards.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.Data;
import java.util.List;
import java.util.UUID;

@Data
@Entity
@Table(name = "patient")
public class Patient {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;
    private String surname;
    private String name;
    private String patronymic;
    private String gender;
    private String birthday;
    private Long police_oms;
    private String hireDate;

    @OneToMany(mappedBy = "patient", cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonIgnoreProperties("patient")
    private List<PatientDisease> patientDiseaseList;
}
