package com.example.med_cards.controllers;

import com.example.med_cards.model.Disease;
import com.example.med_cards.service.DiseaseService;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.web.bind.annotation.*;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
@Tag(description = "Методы работы с болезнями, добавление по файлу и получение всех болезней ",
        name = "Disease")
@RestController
@RequestMapping("/dictionary")
public class DiseaseController {
    @Autowired
    DiseaseService diseaseService;
    @Scheduled(cron = "0 0 0 * * *")
    @PostMapping("/csv/upload")
    public ResponseEntity< ? > uploadFile() {
        String message = "";
        try {
            diseaseService.save();
            message = "The file is uploaded successfully: ";
            return ResponseEntity.status(HttpStatus.OK).body(message);
        } catch (Exception e) {
            message = "The file is not upload successfully: !" + e;
            return ResponseEntity.status(HttpStatus.EXPECTATION_FAILED).body(message);
        }
    }

    @GetMapping("/mkb10")
    public ResponseEntity < ? > getMkb10() {
        Map< String, Object > respDisease = new LinkedHashMap< String, Object >();
        List< Disease > diseaseList = diseaseService.findAll();
        if (!diseaseList.isEmpty()) {
            respDisease.put("status", 1);
            respDisease.put("data", diseaseList);
            return new ResponseEntity < > (respDisease, HttpStatus.OK);
        } else {
            respDisease.clear();
            respDisease.put("status", 0);
            respDisease.put("message", "Data is not found");
            return new ResponseEntity < > (respDisease, HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/disease")
    public ResponseEntity<?> getDisease() {
        Map<String, Object> respDisease = new LinkedHashMap<String, Object>();
        List<Disease> diseaseList=diseaseService.findAll();
        if (!diseaseList.isEmpty()) {
            respDisease.put("status", 1);
            respDisease.put("data", diseaseList);
            return new ResponseEntity<>(respDisease, HttpStatus.OK);
        } else {
            respDisease.clear();
            respDisease.put("status", 0);
            respDisease.put("message", "Data is not found");
            return new ResponseEntity<>(respDisease, HttpStatus.NOT_FOUND);
        }
    }
}
