package com.example.med_cards.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;
import java.util.UUID;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class PatientDisease {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;
    private Date startDate; // один формат записи
    private Date endDate;
    private String prescription;
    @ManyToOne
    @JoinColumn(name = "patient_id", referencedColumnName = "id")
    private Patient patient;
    @ManyToOne
    @JoinColumn(name = "disease_id", referencedColumnName = "id")
    private Disease disease;

    public void addDisease(Disease disease) {
        this.disease = disease;
    }
}
