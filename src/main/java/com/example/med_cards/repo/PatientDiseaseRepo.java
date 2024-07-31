package com.example.med_cards.repo;

import com.example.med_cards.model.PatientDisease;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@RepositoryRestResource
public interface PatientDiseaseRepo extends JpaRepository<PatientDisease , Long> {
    @Transactional

    int deleteByPatientId(Long patientId);

    @Transactional

    @Modifying

    @Query("update PatientDisease set start_date=?1, end_date=?2, prescription=?3, disease=?4 where id=?5")

    int updatePatientDisease(String start_date, String end_date, String prescription, String disease, Long id);

}
