package com.softwareComedians.ClinicalCenterApp.service;

import com.softwareComedians.ClinicalCenterApp.model.Patient;
import com.softwareComedians.ClinicalCenterApp.repository.PatientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PatientService {

    private PatientRepository patientRepository;

    @Autowired
    public PatientService(PatientRepository patientRepository) {
        this.patientRepository = patientRepository;
    }


    public Patient save(Patient patient) {
        return patientRepository.save(patient);
    }
}
