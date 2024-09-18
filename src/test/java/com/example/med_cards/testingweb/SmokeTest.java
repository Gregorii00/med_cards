package com.example.med_cards.testingweb;

import com.example.med_cards.controllers.PatientController;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
public class SmokeTest {

    @Autowired
    private PatientController patientController;

    @Test
    void contextLoads() throws Exception {
        assertThat(patientController).isNotNull();
    }
}
