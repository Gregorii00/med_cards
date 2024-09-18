package com.example.med_cards.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Entity
@NoArgsConstructor
@Getter
@Setter
public class Disease {
    @Id
    private String id;
    @Column(length=1000)
    private String name;
    @OneToMany(mappedBy = "disease")
    @JsonIgnoreProperties("disease")
    private List < PatientDisease > patientDiseaseList;
}