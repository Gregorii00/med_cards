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

    @Query(value = "SELECT migrations.patient_disease.id, migrations.patient_disease.patient_id, " +
            "migrations.patient_disease.prescription, migrations.patient_disease.disease, " +
            "migrations.patient_disease.end_date, migrations.patient_disease.start_date, " +
            "migrations.disease.name AS name FROM migrations.patient_disease LEFT JOIN migrations.disease " +
            "ON migrations.disease.id LIKE migrations.patient_disease.disease", nativeQuery = true)
    List<PatientDisease> findAll();

    @Query(value = "SELECT migrations.patient_disease.id, migrations.patient_disease.patient_id, " +
            "migrations.patient_disease.prescription, migrations.patient_disease.disease, " +
            "migrations.patient_disease.end_date, migrations.patient_disease.start_date, " +
            "migrations.disease.name AS name FROM migrations.patient_disease LEFT JOIN migrations.disease " +
            "ON (migrations.disease.id LIKE migrations.patient_disease.disease) WHERE migrations.patient_disease.patient_id = ? ", nativeQuery = true)
    List<PatientDisease> findDiseaseID(Long id);

}
