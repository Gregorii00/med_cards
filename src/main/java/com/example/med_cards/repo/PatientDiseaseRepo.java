package com.example.med_cards.repo;

import com.example.med_cards.model.PatientDisease;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.List;
import java.util.UUID;

@RepositoryRestResource
public interface PatientDiseaseRepo extends JpaRepository<PatientDisease , UUID> {
    List<PatientDisease> findAll();

}
