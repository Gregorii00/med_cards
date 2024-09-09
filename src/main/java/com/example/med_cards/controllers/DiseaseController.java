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

    @GetMapping("/mkb10")
    public ResponseEntity < ? > getMkb10() {
        return ResponseEntity.ok(diseaseService.findAll());
    }
}
