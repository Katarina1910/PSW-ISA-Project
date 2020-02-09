package com.softwareComedians.ClinicalCenterApp.service;

import com.softwareComedians.ClinicalCenterApp.exception.ApiRequestException;
import com.softwareComedians.ClinicalCenterApp.model.Clinic;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class ClinicsServiceTest {
    @Autowired
    private  ClinicsService clinicsService;

    @Test
    public void findAll() {
        List<Clinic> clinics = (List<Clinic>) clinicsService.findAll();
        assertEquals(clinics.size(), 3);
    }
    @Test
    public void findById() {
        Clinic clinic = clinicsService.findById(1L);

        assertEquals(clinic.getId() , 1L);
        assertEquals(clinic.getName(), "klinika1");
        assertEquals(clinic.getAddress(), "Novi Sad");
        assertEquals(clinic.getDescription(), "Opis klinike1...");

    }

    @Test(expected = ApiRequestException.class)
    public void findById_WhenIdNotValid() {
        Clinic clinic = clinicsService.findById(1000L);
    }
}


