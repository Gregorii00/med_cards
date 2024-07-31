package com.example.med_cards.repo;

import com.example.med_cards.model.Patient;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.transaction.annotation.Transactional;


@RepositoryRestResource
public interface PatientRepo extends JpaRepository<Patient, Long> {
    @Transactional

    @Modifying

    @Query("update Patient set surname=?1, name=?2, patronymic=?3, gender=?4, birthday=?5, police_oms=?6, hireDate=?7 where id=?8")

    int updatePatient(String surname, String name, String patronymic, String gender, String birthday, long police_oms, String hireDate, Long id);

}
