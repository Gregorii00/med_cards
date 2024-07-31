package com.example.med_cards.controllers;

import com.example.med_cards.model.Patient;
import com.example.med_cards.model.PatientDisease;
import com.example.med_cards.service.DiseaseService;
import com.example.med_cards.service.PatientDiseaseService;
import com.example.med_cards.service.PatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

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
    public ResponseEntity < ? > save(@PathVariable("patient_id") Long id, @RequestBody PatientDisease patientDisease) {
        Map < String, Object > respPatientDisease = new LinkedHashMap < String, Object > ();
        Patient patient = patientService.findById(id);
        patientDisease.setPatient(patient);
        patientDiseaseService.save(patientDisease);
        respPatientDisease.put("status", 1);
        respPatientDisease.put("message", "Record is Saved Successfully!");
        return new ResponseEntity < > (respPatientDisease, HttpStatus.CREATED);
    }
    @GetMapping("/{patient_id}/disease")
    public ResponseEntity < ? > getPatientDisease() {
        Map < String, Object > respPatientDisease = new LinkedHashMap < String, Object > ();
        List < PatientDisease > patientDiseaseList = patientDiseaseService.findAll();
        if (!patientDiseaseList.isEmpty()) {
            for (int i = 0; i<patientDiseaseList.size();i++){
                patientDiseaseList.get(i).setDisease_message(diseaseService.findById(patientDiseaseList.get(i).getDisease()).getName());
            }
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

    public ResponseEntity<?> deleteById(@PathVariable Long id) {

        Map<String, Object> respPatientDisease = new LinkedHashMap<String, Object>();

        patientDiseaseService.deleteById(id);

        respPatientDisease.put("status", 1);

        respPatientDisease.put("data", "Record is deleted successfully!");

        return new ResponseEntity<>(respPatientDisease, HttpStatus.OK);

    }

    @PutMapping("/{patient_id}/disease/{id}")
    public ResponseEntity<?> updatePatientDisease(@RequestBody PatientDisease patientDisease, @PathVariable Long id) {

        Map<String, Object> respPatientDisease = new LinkedHashMap<String, Object>();

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
