package com.softwareComedians.ClinicalCenterApp.controller;


import com.softwareComedians.ClinicalCenterApp.common.consts.UserRoles;
import com.softwareComedians.ClinicalCenterApp.dto.ConsultTermDTO;
import com.softwareComedians.ClinicalCenterApp.dto.PatientDTO;
import com.softwareComedians.ClinicalCenterApp.dto.UserDTO;
import com.softwareComedians.ClinicalCenterApp.mappers.UserMapper;
import com.softwareComedians.ClinicalCenterApp.model.ConsultTerm;
import com.softwareComedians.ClinicalCenterApp.model.Patient;
import com.softwareComedians.ClinicalCenterApp.model.RequestForPatientRegistration;
import com.softwareComedians.ClinicalCenterApp.model.User;
import com.softwareComedians.ClinicalCenterApp.repository.AuthorityRepository;
import com.softwareComedians.ClinicalCenterApp.service.ConsultTermService;
import com.softwareComedians.ClinicalCenterApp.service.PatientService;
import com.softwareComedians.ClinicalCenterApp.service.RequestForPatientRegistrationService;
import com.softwareComedians.ClinicalCenterApp.service.impl.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping(value = "/api/patient")
@CrossOrigin
public class PatientController {

    @Autowired
    private PatientService patientService;
    @Autowired
    private AuthorityRepository authorityRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private RequestForPatientRegistrationService requestForPatientRegistrationService;

    @Autowired
    private ConsultTermService consultTermService;

    @Autowired
    private UserServiceImpl userService;

    @Autowired
    public PatientController(PatientService patientService, RequestForPatientRegistrationService requestForPatientRegistrationService) {
        this.patientService = patientService;
        this.requestForPatientRegistrationService = requestForPatientRegistrationService;
    }

    @GetMapping(value = "/getAll")
    public ResponseEntity<List<PatientDTO>> getAll() {

        List<Patient> patients = patientService.findAll();
        List<PatientDTO> patientsDTO = new ArrayList<>();
        for (Patient p : patients) {
            patientsDTO.add(new PatientDTO(p));
        }

        return new ResponseEntity<>(patientsDTO, HttpStatus.OK);
    }

    //u front endu ovo pozovi za accept(gadja ga link)
    @GetMapping(value = "add/{id}")
    public ResponseEntity<Void> addPatient(@PathVariable Long id){

        RequestForPatientRegistration request = requestForPatientRegistrationService.findOne(id);
        requestForPatientRegistrationService.remove(id);

        Patient patient = new Patient(request.getUserData());
        patient.setActivated(true);
        patient.setRole(UserRoles.ROLE_PATIENT);
        patient = patientService.save(patient);

        if(patient!=null)
            return new ResponseEntity<>(HttpStatus.CREATED);
        else
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }

    @GetMapping("/getAllExaminations")
    public ResponseEntity<List<ConsultTermDTO>> getAllExaminations() {
        List<ConsultTerm> terms = consultTermService.findAll();
        List<ConsultTermDTO> termsDTO = new ArrayList<>();

        for (ConsultTerm t : terms) {
            termsDTO.add(new ConsultTermDTO(t));
        }

        return new ResponseEntity<>(termsDTO, HttpStatus.OK);
    }

    @PostMapping(value = "/edit")
    @PreAuthorize("ROLE_PATIENT")
    public ResponseEntity<UserDTO> editPatient(@RequestBody PatientDTO patientDTO) {

        User userInfo = userService.findById(patientDTO.getId());
        userInfo.setName(patientDTO.getName());
        userInfo.setSurname(patientDTO.getSurname());
        userInfo.setPhone(patientDTO.getPhone());
        userInfo.setUsername(patientDTO.getUsername());
        userInfo.setPassword(patientDTO.getPassword());
        userInfo.setActivated(patientDTO.isActivated());
        userInfo.setCountry(patientDTO.getCountry());
        userInfo.setCity(patientDTO.getCity());
        userInfo.setAddress(patientDTO.getAddress());
        userInfo.setUcidn(patientDTO.getUcidn());

        userInfo = userService.save(userInfo);

        return new ResponseEntity<>(UserMapper.toDto(userInfo), HttpStatus.OK);
    }

}
