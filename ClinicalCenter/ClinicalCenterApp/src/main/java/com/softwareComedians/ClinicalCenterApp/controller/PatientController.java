package com.softwareComedians.ClinicalCenterApp.controller;


import com.softwareComedians.ClinicalCenterApp.model.Patient;
import com.softwareComedians.ClinicalCenterApp.model.RequestForPatientRegistration;
import com.softwareComedians.ClinicalCenterApp.service.PatientService;
import com.softwareComedians.ClinicalCenterApp.service.RequestForPatientRegistrationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/api/patient")
@CrossOrigin
public class PatientController {

    private PatientService patientService;
    private RequestForPatientRegistrationService requestForPatientRegistrationService;

    @Autowired
    public PatientController(PatientService patientService, RequestForPatientRegistrationService requestForPatientRegistrationService) {
        this.patientService = patientService;
        this.requestForPatientRegistrationService = requestForPatientRegistrationService;
    }

    //u front endu ovo pozovi za accept(gadja ga link)
    @GetMapping(value = "add/{id}")
    public ResponseEntity<Void> addPatient(@PathVariable Long id){

        RequestForPatientRegistration request = requestForPatientRegistrationService.findOne(id);
        requestForPatientRegistrationService.remove(id);

        Patient patient = new Patient(request.getUserData());
        patient.setActivated(true);
        patient.setRole("PATIENT");
        patient = patientService.save(patient);

        if(patient!=null)
            return new ResponseEntity<>(HttpStatus.CREATED);
        else
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);


    }
}
