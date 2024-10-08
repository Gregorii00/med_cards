package com.example.med_cards.controllers;

import com.example.med_cards.dto.disease.DiseaseDto;
import com.example.med_cards.dto.patient_disease.PatientDiseaseDto;
import com.example.med_cards.dto.patient_disease.PatientDiseaseDtoCreate;
import com.example.med_cards.dto.patient_disease.PatientDiseaseDtoView;
import com.example.med_cards.model.PatientDisease;
import com.example.med_cards.service.PatientDiseaseService;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@Tag(description = "Методы работы с записями болезней пациентов",
        name = "Patient Disease")
@RestController
@RequestMapping("/patient")
public class PatientDiseaseController {

    private final PatientDiseaseService patientDiseaseService;

    public PatientDiseaseController(PatientDiseaseService patientDiseaseService) {
        this.patientDiseaseService = patientDiseaseService;
    }

    @PostMapping("/{patient_id}/disease")
    public PatientDiseaseDtoView save(@PathVariable("patient_id") UUID id, @Valid @RequestBody PatientDiseaseDtoCreate patientDiseaseDtoCreate) {
        return patientDiseaseService.save(patientDiseaseDtoCreate, id);
    } // сделать void вместо ResponseEntity

    @GetMapping("/{patient_id}/disease")
    public List<PatientDiseaseDtoView> getPatientDisease(@PathVariable("patient_id") UUID id) {
        return patientDiseaseService.findAll(id);
    }  // сделать модель из дто вместо ResponseEntity

    @DeleteMapping("/{patient_id}/disease/{id}")
    public ResponseEntity<?> deleteById(@PathVariable UUID id) {
        return new ResponseEntity<>(patientDiseaseService.deleteById(id), HttpStatus.OK);
    } // сделать void вместо ResponseEntity

    @PutMapping("/{patient_id}/disease/{id}")
    public void updatePatientDisease(@Valid @RequestBody PatientDiseaseDto patientDiseaseDto, @PathVariable UUID id) {
        patientDiseaseService.updatePatientDisease(patientDiseaseDto, id);
    }

}
