package com.example.med_cards.controllers;

import com.example.med_cards.model.Disease;
import com.example.med_cards.scan.CsvUtility;
import com.example.med_cards.service.DiseaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/dictionary")
public class DiseaseController {
    @Autowired
    DiseaseService diseaseService;
    // Обновлять каждый день fixedRate = 24 * 60 * 60 * 1000
//    @Scheduled(fixedRate = 30 * 60 * 1000)
    @PostMapping("/csv/upload")
    public ResponseEntity< ? > uploadFile(@RequestParam("file") MultipartFile file) {
        String message = "";
        if (CsvUtility.hasCsvFormat(file)) {
            try {
                diseaseService.save(file);
                message = "The file is uploaded successfully: " + file.getOriginalFilename();
                return ResponseEntity.status(HttpStatus.OK).body(message);
            } catch (Exception e) {
                message = "The file is not upload successfully: " + file.getOriginalFilename() + "!" + e;
                return ResponseEntity.status(HttpStatus.EXPECTATION_FAILED).body(message);
            }
        }
        message = "Please upload an csv file!";
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(message);
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
