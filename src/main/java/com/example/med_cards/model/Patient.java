package com.example.med_cards.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.Data;
import java.util.List;

@Data
@Entity
@Table(name = "patient")
public class Patient {
    @Id
    @GeneratedValue
    private long id;
    private String surname;
    private String name;
    private String patronymic;
    private String gender;
    private String birthday;
    private long police_oms;
    private String hireDate;

    @OneToMany(mappedBy = "patient", cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonIgnoreProperties("patient")
    private List<PatientDisease> patientDiseaseList;
}
