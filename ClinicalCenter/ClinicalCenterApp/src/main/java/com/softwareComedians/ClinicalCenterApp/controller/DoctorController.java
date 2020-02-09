package com.softwareComedians.ClinicalCenterApp.controller;

import com.softwareComedians.ClinicalCenterApp.dto.DoctorDTO;
import com.softwareComedians.ClinicalCenterApp.model.Doctor;
import com.softwareComedians.ClinicalCenterApp.repository.AuthorityRepository;
import com.softwareComedians.ClinicalCenterApp.service.ClinicAdminService;
import com.softwareComedians.ClinicalCenterApp.service.DoctorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "api/doctors")
@CrossOrigin
public class DoctorController {

    DoctorService doctorService;

    @Autowired
    private PasswordEncoder passwordEncoder;


    @Autowired
    private AuthorityRepository authorityRepository;

    @Autowired
    private ClinicAdminService clinicAdminService;

    @Autowired
    public DoctorController(DoctorService doctorService){
        this.doctorService=doctorService;
    }

    @GetMapping(value = "/getAll")
    public ResponseEntity<List<DoctorDTO>> getAllDoctors() {
        List<DoctorDTO> doctorsDTO = doctorService.getAllDoctors();
        return new ResponseEntity<>(doctorsDTO, HttpStatus.OK);
    }

    @PostMapping(value = "/{id}")
    public ResponseEntity<DoctorDTO> addDoctor(@PathVariable Long id,@RequestBody DoctorDTO doctorDTO) {
        Doctor doctor = doctorService.addDoctor(id,doctorDTO);
        return new ResponseEntity<>(new DoctorDTO(doctor), HttpStatus.CREATED);
    }

    @PutMapping(value = "/rateDoctor/{rate}")
    public ResponseEntity<DoctorDTO> rateDoctorGrade (@RequestBody DoctorDTO doctorDTO, @PathVariable Double rate) {
        Doctor doc = doctorService.rateDoctorGrade(doctorDTO, rate);
        return new ResponseEntity<>(new DoctorDTO(doc), HttpStatus.OK);
    }

    @DeleteMapping(value = "/del/{email}")
    public ResponseEntity<String> deletePost(@PathVariable String email) {
        doctorService.remove(email);
        return new ResponseEntity<>(email, HttpStatus.OK);
    }

    @DeleteMapping(value = "/del/{id}")
    public ResponseEntity<Long> deleteDoctor(@PathVariable Long id) {
        doctorService.removeDoctor(id);
        return new ResponseEntity<>(id, HttpStatus.OK);
    }
}
