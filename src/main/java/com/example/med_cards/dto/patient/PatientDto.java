package com.example.med_cards.dto.patient;

import com.example.med_cards.dto.patient_disease.PatientDiseaseDto;
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
public class PatientDto {
    private UUID id;
    @NotNull(message = "Заполнение поля 'фамилия' обязательно")
    private String surname;
    @NotNull(message = "Заполнение поля 'имя' обязательно")
    private String name;
    private String patronymic;
    @NotNull(message = "Заполнение поля 'пол' обязательно")
    private String gender;
    @NotNull(message = "Заполнение поля 'день рождения' обязательно")
    @Past(message = "Birthday date in the future")
    private Date birthday;
    @Digits(fraction = 0, integer = 16, message="Number should contain 16 digits.")
    @NotNull(message = "Заполнение поля 'полис' обязательно")
    private Long police_oms;
    private LocalDateTime created_at;
    private LocalDateTime updated_at;
    private List<PatientDiseaseDto> patientDiseaseDtoList;
}
