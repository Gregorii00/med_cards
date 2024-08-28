package com.example.med_cards.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;
import java.util.UUID;

@Entity
@NoArgsConstructor
@Getter
@Setter
@EntityListeners(AuditingEntityListener.class)
public class Patient {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
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
//    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @CreatedDate
    private LocalDateTime hireDate;

    @OneToMany(mappedBy = "patient", cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonIgnoreProperties("patient")
    private List<PatientDisease> patientDiseaseList;
}