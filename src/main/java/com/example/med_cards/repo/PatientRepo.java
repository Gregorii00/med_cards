package com.example.med_cards.repo;

import com.example.med_cards.model.Patient;
import com.example.med_cards.model.PatientDisease;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;
import java.util.UUID;


@RepositoryRestResource
public interface PatientRepo extends JpaRepository<Patient, UUID> {
    @Transactional

    @Modifying

    @Query("update Patient set surname=?1, name=?2, patronymic=?3, gender=?4, birthday=?5, police_oms=?6, hireDate=?7 where id=?8")

    int updatePatient(String surname, String name, String patronymic, String gender, Date birthday, Long police_oms, Date hireDate, UUID id);
}
