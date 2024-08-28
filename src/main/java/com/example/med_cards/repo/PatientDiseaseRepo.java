package com.example.med_cards.repo;

import com.example.med_cards.model.PatientDisease;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import java.util.List;
import java.util.UUID;

@RepositoryRestResource
public interface PatientDiseaseRepo extends JpaRepository<PatientDisease , UUID> {

//    @Transactional
//    @Modifying
//    @Query(value = "update PatientDisease pd set pd.start_date=:start_date, pd.end_date=:end_date, pd.prescription=:prescription, pd.disease_id=:disease_id where pd.id=:id")

//    int updatePatientDisease(@Param("start_date") Date start_date,@Param("end_date") Date end_date,@Param("prescription") String prescription,
//                             @Param("disease_id") String disease_id, @Param("id")UUID id);
    List<PatientDisease> findAll();


}
