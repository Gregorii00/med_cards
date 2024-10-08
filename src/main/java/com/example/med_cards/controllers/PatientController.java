package com.example.med_cards.controllers;

import com.example.med_cards.dto.patient.PatientDto;
import com.example.med_cards.dto.patient.PatientDtoCreate;
import com.example.med_cards.dto.patient.PatientDtoView;
import com.example.med_cards.mapper.patient.PatientMapper;
import com.example.med_cards.service.PatientService;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@Tag(description = "Методы работы с пациентами",
        name = "Patient")
@RestController
@RequestMapping("/patient")
public class PatientController {

    private final PatientService patientService;
    private final PatientMapper patientMapper;


    public PatientController(PatientService patientService, PatientMapper patientMapper) {
        this.patientService = patientService;
        this.patientMapper = patientMapper;
    }

    @PostMapping("/")
    public PatientDtoView save(@Valid @RequestBody PatientDtoCreate patientDtoCreate) {
        return patientService.save(patientDtoCreate);
    }
    @GetMapping("/")
    public  List < PatientDtoView >  getAllPatient() {
        return patientService.findPatientList();
    }
    @GetMapping("/{patient_id}")
    public PatientDtoView getPatient(@PathVariable("patient_id") UUID id) {
        return patientMapper.toDtoView(patientService.findById(id));
    }
    @DeleteMapping("/{patient_id}")
    public ResponseEntity<?> deleteById(@PathVariable("patient_id") UUID id) {
        return new ResponseEntity<>(patientService.deleteById(id), HttpStatus.OK);
    }
    @PutMapping("/{patient_id}")
    public void updatePatient(@Valid @RequestBody PatientDtoView patientDtoView, @PathVariable("patient_id") UUID id) {
            patientService.updatePatient(patientDtoView, id);
    }
}
