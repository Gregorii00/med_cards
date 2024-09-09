package com.example.med_cards.controllers;

import com.example.med_cards.model.Patient;
import com.example.med_cards.service.DiseaseService;
import com.example.med_cards.service.PatientDiseaseService;
import com.example.med_cards.service.PatientService;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@Tag(description = "Методы работы с пациентами",
        name = "Patient")
@RestController
@RequestMapping("/patient")
public class PatientController {
    @Autowired

    private PatientService patientService;
    @Autowired
    private PatientDiseaseService patientDiseaseService;
    @Autowired
    private DiseaseService diseaseService;
    @PostMapping("/")
    public ResponseEntity<?> save(@Valid @RequestBody Patient patient) {
        return new ResponseEntity<>(patientService.save(patient), HttpStatus.CREATED);
    }
    @GetMapping("/")
    public ResponseEntity < List < Patient > > getAllPatient() {
        return ResponseEntity.ok(patientService.findPatientList());
    }
    @GetMapping("/{patient_id}")
    public ResponseEntity <?> getPatient(@PathVariable("patient_id") UUID id) {
        return ResponseEntity.ok(patientService.findById(id));
    }
    @DeleteMapping("/{patient_id}")
    public ResponseEntity<?> deleteById(@PathVariable("patient_id") UUID id) {
        return new ResponseEntity<>(patientService.deleteById(id), HttpStatus.OK);
    }
    @PutMapping("/{patient_id}")
    public ResponseEntity<?> updatePatient(@Valid @RequestBody Patient patient, @PathVariable("patient_id") UUID id) {
        ResponseEntity respPatient =patientService.updatePatient(patient, id);
        return new ResponseEntity<>(respPatient , respPatient.getStatusCode());
    }
}
