package com.example.med_cards.controllers;

import com.example.med_cards.model.Patient;
import com.example.med_cards.model.PatientDisease;
import com.example.med_cards.service.DiseaseService;
import com.example.med_cards.service.PatientDiseaseService;
import com.example.med_cards.service.PatientService;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.*;

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
    public ResponseEntity < ? > save(@PathVariable("patient_id") UUID id, @RequestBody PatientDisease patientDisease) {
        Map < String, Object > respPatientDisease = new LinkedHashMap < String, Object > ();
        Patient patient = patientService.findById(id);
        Date dateNow = Date.from(LocalDateTime.now().atZone(ZoneId.systemDefault()).toInstant());

        if (patientDisease.getStart_date().after(dateNow)){

            return new ResponseEntity<>("Start date in the future", HttpStatus.NOT_FOUND);

        } else if (patientDisease.getEnd_date().after(dateNow)) {
            return new ResponseEntity<>("End date in the future", HttpStatus.NOT_FOUND);
        }
        else{
            patientDisease.setPatient(patient);
            patientDiseaseService.save(patientDisease);
            respPatientDisease.put("status", 1);
            respPatientDisease.put("message", "Record is Saved Successfully!");
            return new ResponseEntity < > (respPatientDisease, HttpStatus.CREATED);
        }

    }
    @GetMapping("/{patient_id}/disease")
    public ResponseEntity < ? > getPatientDisease() {
        Map < String, Object > respPatientDisease = new LinkedHashMap < String, Object > ();
        List < PatientDisease > patientDiseaseList = patientDiseaseService.findAll();
        if (!patientDiseaseList.isEmpty()) {
            respPatientDisease.put("status", 1);
            respPatientDisease.put("data", patientDiseaseList);
            return new ResponseEntity < > (respPatientDisease, HttpStatus.OK);
        } else {
            respPatientDisease.clear();
            respPatientDisease.put("status", 0);
            respPatientDisease.put("message", "Data is not found");
            return new ResponseEntity < > (respPatientDisease, HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/{patient_id}/disease/{id}")

    public ResponseEntity<?> deleteById(@PathVariable UUID id) {

        Map<String, Object> respPatientDisease = new LinkedHashMap<String, Object>();

        patientDiseaseService.deleteById(id);

        respPatientDisease.put("status", 1);

        respPatientDisease.put("data", "Record is deleted successfully!");

        return new ResponseEntity<>(respPatientDisease, HttpStatus.OK);

    }

    @PutMapping("/{patient_id}/disease/{id}")
    public ResponseEntity<?> updatePatientDisease(@RequestBody PatientDisease patientDisease, @PathVariable UUID id) {

        Map<String, Object> respPatientDisease = new LinkedHashMap<String, Object>();
        Date dateNow = Date.from(LocalDateTime.now().atZone(ZoneId.systemDefault()).toInstant());
        if (patientDisease.getStart_date().after(dateNow)){

            return new ResponseEntity<>("Start date in the future", HttpStatus.NOT_FOUND);

        } else if (patientDisease.getEnd_date().after(dateNow)) {
            return new ResponseEntity<>("End date in the future", HttpStatus.NOT_FOUND);
        }
        else{
            int record=patientDiseaseService.updatePatientDisease(patientDisease.getStart_date(), patientDisease.getEnd_date(), patientDisease.getPrescription(),
                    patientDisease.getDisease(), id);

            if (record!=0) {

                respPatientDisease.put("status", 1);

                respPatientDisease.put("data", record+" record is updated.");

                return new ResponseEntity<>(respPatientDisease, HttpStatus.OK);

            } else {

                respPatientDisease.clear();

                respPatientDisease.put("status", 0);

                respPatientDisease.put("message", "Data is not found");

                return new ResponseEntity<>(respPatientDisease, HttpStatus.NOT_FOUND);

            }
        }


    }

}
