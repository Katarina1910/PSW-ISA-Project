package com.softwareComedians.ClinicalCenterApp.service;

import com.softwareComedians.ClinicalCenterApp.model.Patient;
import org.junit.Test;
import org.junit.jupiter.api.BeforeEach;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class PatientServiceTest {

    @Autowired
    private PatientService patientService;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @BeforeEach
    public void setUp() {
    }

    @Test
    public void findAll() {
        List<Patient> patients = (List<Patient>) patientService.findAll();
        assertEquals(patients.size(), 2);
    }

    @Test
    public void findById() {
        Patient patient = patientService.findById(3L);

        assertEquals(patient.getName(),"Ron");
        assertEquals(patient.getSurname(),"Lo");
        //assertEquals(patient.getPassword(),passwordEncoder.encode("123"));
        assertEquals(patient.getCity(),"Nevesinje");
        assertEquals(patient.getCountry(),"BiH");
        assertEquals(patient.getAddress(),"Ive Andrica 11");
        assertEquals(patient.getPhone(),"06566551288");
    }
}
