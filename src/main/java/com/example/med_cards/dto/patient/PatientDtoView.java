package com.example.med_cards.dto.patient;

import com.example.med_cards.dto.patient_disease.PatientDiseaseDto;
import com.example.med_cards.dto.patient_disease.PatientDiseaseDtoView;
import jakarta.validation.constraints.Digits;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Past;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;
import java.util.UUID;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class PatientDtoView {
    private UUID id;
    private String surname;
    private String name;
    private String patronymic;
    private String gender;
    private Date birthday;
    private Long police_oms;
    private LocalDateTime created_at;
    private LocalDateTime updated_at;
    private List<PatientDiseaseDtoView> patientDiseaseDtoViewList;
}
