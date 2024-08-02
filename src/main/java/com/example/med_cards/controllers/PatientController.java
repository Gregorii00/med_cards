package com.example.med_cards.controllers;

import com.example.med_cards.model.Patient;
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

    @PostMapping("/save-all")

    public ResponseEntity< ? > save(@RequestBody List< Patient > patients) {

        Map< String, Object > respPatient = new LinkedHashMap< String, Object >();

        patientService.saveAll(patients);

        respPatient.put("status", 1);

        respPatient.put("message", "Record is Saved Successfully!");

        return new ResponseEntity < > (respPatient, HttpStatus.CREATED);

    }
    @GetMapping("/")
    public ResponseEntity < ? > getPatient() {
        Map < String, Object > respPatient = new LinkedHashMap < String, Object > ();
        List < Patient > patientList = patientService.findPatientList();
        if (!patientList.isEmpty()) {

            respPatient.put("status", 1);
            respPatient.put("data", patientList);
            return new ResponseEntity < > (respPatient, HttpStatus.OK);
        } else {
            respPatient.clear();
            respPatient.put("status", 0);
            respPatient.put("message", "Data is not found");
            return new ResponseEntity < > (respPatient, HttpStatus.NOT_FOUND);
        }
    }
    @PostMapping("/")

    public ResponseEntity < ? > save(@RequestBody Patient patient) {

        Map < String, Object > respPatient = new LinkedHashMap < String, Object > ();

        patient.setHireDate(Date.from(LocalDateTime.now().atZone(ZoneId.systemDefault()).toInstant()));


        patientService.save(patient);

        respPatient.put("status", 1);

        respPatient.put("message", "Record is Saved Successfully!");

        return new ResponseEntity < > (respPatient, HttpStatus.CREATED);

    }

//    @GetMapping("/{patient_id}")
//
//    public ResponseEntity < ? > getById(@PathVariable Long patient_id) {
//
//        Map < String, Object > respPatient = new LinkedHashMap < String, Object > ();
//
//        Patient patient = patientService.getById(patient_id);
//
//        if (patient != null) {
//
//            respPatient.put("status", 1);
//
//            respPatient.put("data", patient);
//
//            return new ResponseEntity < > (respPatient, HttpStatus.OK);
//
//        } else {
//
//            respPatient.clear();
//
//            respPatient.put("status", 0);
//
//            respPatient.put("message", "Data is not found");
//
//            return new ResponseEntity < > (respPatient, HttpStatus.NOT_FOUND);
//
//        }
//
//    }
    @DeleteMapping("/{patient_id}")

    public ResponseEntity<?> deleteById(@PathVariable UUID patient_id) {

        Map<String, Object> respPatient = new LinkedHashMap<String, Object>();

        patientService.deleteById(patient_id);

        respPatient.put("status", 1);

        respPatient.put("data", "Record is deleted successfully!");

        return new ResponseEntity<>(respPatient, HttpStatus.OK);

    }

    @PutMapping("/{patient_id}")
    public ResponseEntity<?> updatePatient(@RequestBody Patient patient, @PathVariable UUID patient_id) {

        Map<String, Object> respPatient = new LinkedHashMap<String, Object>();
        Date date = Date.from(LocalDateTime.now().atZone(ZoneId.systemDefault()).toInstant());

        int record=patientService.updatePatient(patient.getSurname(), patient.getName(), patient.getPatronymic(),
                patient.getGender(), patient.getBirthday(), patient.getPolice_oms(), date, patient_id);

        if (record!=0) {

            respPatient.put("status", 1);

            respPatient.put("data", record+" record is updated.");

            return new ResponseEntity<>(respPatient, HttpStatus.OK);

        } else {

            respPatient.clear();

            respPatient.put("status", 0);

            respPatient.put("message", "Data is not found");

            return new ResponseEntity<>(respPatient, HttpStatus.NOT_FOUND);

        }

    }

}
