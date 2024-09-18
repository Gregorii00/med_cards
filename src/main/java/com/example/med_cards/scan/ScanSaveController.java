package com.example.med_cards.scan;

import com.example.med_cards.service.DiseaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ScanSaveController {
    @Autowired
    DiseaseService diseaseService;
    @Scheduled(cron = "0 0 0 * * *")
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
}
