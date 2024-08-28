package com.example.med_cards.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Past;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.util.Date;
import java.util.UUID;

@Entity
@NoArgsConstructor
@Getter
@Setter
@EntityListeners(AuditingEntityListener.class)
public class PatientDisease {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;
    @NotNull(message = "Заполнение поля 'начало болезни' обязательно")
    @Past(message = "Дата начала болезни в будущем")
    private Date start_date;
    @Past(message = "Дата окончания болезни в будущем")
    private Date end_date;
    @NotNull(message = "Заполнение поля 'назначение' обязательно")
    @Size(max = 1024, message = "Превышена длинна для назначений")
    private String prescription;
    @ManyToOne
    @JoinColumn(name = "patient_id", referencedColumnName = "id")
    @JsonIgnoreProperties("patientDiseaseList")
    private Patient patient;
    @NotNull(message = "Заполнение поля 'болезнь' обязательно")
    @ManyToOne
    @JoinColumn(name = "disease_id", referencedColumnName = "id")
    @JsonIgnoreProperties("patientDiseaseList")
    private Disease disease;


}
