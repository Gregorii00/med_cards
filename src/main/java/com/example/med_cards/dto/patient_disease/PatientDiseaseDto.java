package com.example.med_cards.dto.patient_disease;

import com.example.med_cards.dto.disease.DiseaseDto;
import jakarta.persistence.*;
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
public class PatientDiseaseDto {
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;
    @NotNull(message = "Заполнение поля 'начало болезни' обязательно")
    @Past(message = "Дата начала болезни в будущем")
    private Date startDate;
    @Past(message = "Дата окончания болезни в будущем")
    private Date endDate;
    @NotNull(message = "Заполнение поля 'назначение' обязательно")
    @Size(max = 1024, message = "Превышена длинна для назначений")
    private String prescription;
    @NotNull(message = "Заполнение поля 'болезнь' обязательно")
    private DiseaseDto diseaseDto;

    public void addDisease(DiseaseDto disease){
        this.diseaseDto = disease;
    }

}
