package com.softwareComedians.ClinicalCenterApp.service;

import com.softwareComedians.ClinicalCenterApp.exception.ApiRequestException;
import com.softwareComedians.ClinicalCenterApp.model.Clinic;
import com.softwareComedians.ClinicalCenterApp.repository.ClinicAdminRepository;
import com.softwareComedians.ClinicalCenterApp.repository.ClinicsRepository;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment= SpringBootTest.WebEnvironment.RANDOM_PORT)
public class ClinicsServiceUnitTest {
    @Autowired
    ClinicsService  clinicsService;

    @MockBean
    ClinicsRepository clinicsRepositoryMocked;

    @Autowired
    ClinicAdminService clinicAdminService;

    @MockBean
    ClinicAdminRepository clinicAdminRepository;


    @Before
    public void setUp() throws ParseException {
        MockitoAnnotations.initMocks(this);

        Clinic clinic = new Clinic(); clinic.setId(1L);
        Clinic clinic1 = new Clinic(); clinic1.setId(2L);

        List<Clinic> clinics = new ArrayList<>();
        clinics.add(clinic);
        clinics.add(clinic1);

        Mockito.when(clinicsRepositoryMocked.findById(clinic.getId())).thenReturn(Optional.of(clinic));
        Mockito.when(clinicsRepositoryMocked.findAll()).thenReturn(clinics);


    }

    @Test
    public void whenValidId_getById() {
        Long id = 1L;
        Clinic clinic = clinicsService.findById(id);

        assertEquals(id, clinic.getId());
    }

    @Test
    public void whenValidId_getAll() {
        List<Clinic> clinics = clinicsService.findAll();
        assertEquals(clinics.size(), 2);
    }

    @Test(expected = ApiRequestException.class)
    public void whenInvalidId_thenThrowEx() {
        Long id = 150L;
        Clinic clinic = clinicsService.findById(id);
    }


}
