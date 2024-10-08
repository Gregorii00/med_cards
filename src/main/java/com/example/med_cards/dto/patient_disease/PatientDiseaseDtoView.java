package com.example.med_cards.dto.patient_disease;

import com.example.med_cards.dto.disease.DiseaseDto;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Past;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;
import java.util.UUID;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class PatientDiseaseDtoView {
    private UUID id;
    private Date startDate;
    private Date endDate;
    private String prescription;
    private DiseaseDto diseaseDto;
}
