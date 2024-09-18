package com.example.med_cards.controllers;

import com.example.med_cards.model.PatientDisease;
import com.example.med_cards.service.DiseaseService;
import com.example.med_cards.service.PatientDiseaseService;
import com.example.med_cards.service.PatientService;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@Tag(description = "Методы работы с записями болезней пациентов",
        name = "Patient Disease")
@RestController
@RequestMapping("/patient")
public class PatientDiseaseController {
    @Autowired
    private PatientService patientService;
    @Autowired
    private PatientDiseaseService patientDiseaseService;

    @Autowired
    private DiseaseService diseaseService;

    @PostMapping("/{patient_id}/disease")
    public ResponseEntity < ? > save(@PathVariable("patient_id") UUID id, @Valid @RequestBody PatientDisease patientDisease) {
        return new ResponseEntity < > (patientDiseaseService.save(patientDisease, id), HttpStatus.CREATED);
    }
    @GetMapping("/{patient_id}/disease")
    public ResponseEntity < ? > getPatientDisease() {
        return ResponseEntity.ok(patientDiseaseService.findAll());
    }

    @DeleteMapping("/{patient_id}/disease/{id}")
    public ResponseEntity<?> deleteById(@PathVariable UUID id) {
        return new ResponseEntity<>(patientDiseaseService.deleteById(id), HttpStatus.OK);
    }

    @PutMapping("/{patient_id}/disease/{id}")
    public ResponseEntity<?> updatePatientDisease(@Valid @RequestBody PatientDisease patientDisease, @PathVariable UUID id) {
        ResponseEntity respPatient = patientDiseaseService.updatePatientDisease(patientDisease, id);
        return new ResponseEntity<>(respPatient , respPatient.getStatusCode());
    }

}
