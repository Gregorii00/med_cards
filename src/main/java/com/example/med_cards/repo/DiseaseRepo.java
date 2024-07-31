package com.example.med_cards.repo;

import com.example.med_cards.model.Disease;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.transaction.annotation.Transactional;

@RepositoryRestResource
public interface DiseaseRepo extends JpaRepository<Disease, Long> {

    Disease findById(String id);

}
