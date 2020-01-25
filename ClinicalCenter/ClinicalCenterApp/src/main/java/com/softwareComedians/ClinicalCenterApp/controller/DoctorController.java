package com.softwareComedians.ClinicalCenterApp.controller;

import com.softwareComedians.ClinicalCenterApp.common.consts.UserRoles;
import com.softwareComedians.ClinicalCenterApp.dto.DoctorDTO;
import com.softwareComedians.ClinicalCenterApp.model.Authority;
import com.softwareComedians.ClinicalCenterApp.model.Doctor;
import com.softwareComedians.ClinicalCenterApp.repository.AuthorityRepository;
import com.softwareComedians.ClinicalCenterApp.service.DoctorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
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
    public DoctorController(DoctorService doctorService){
        this.doctorService=doctorService;
    }

    @GetMapping(value = "/getAll")
    public ResponseEntity<List<DoctorDTO>> getAll() {

        List<Doctor> doctors = doctorService.findAll();
        List<DoctorDTO> doctorsDTO = new ArrayList<>();
        for (Doctor d : doctors) {
            doctorsDTO.add(new DoctorDTO(d));
        }

        return new ResponseEntity<>(doctorsDTO, HttpStatus.OK);
    }

    @PostMapping()
    public ResponseEntity<DoctorDTO> addDoctor(@RequestBody DoctorDTO doctorDTO) {
        Doctor doctor = new Doctor();
        doctor.setId(doctorDTO.getId());
        doctor.setName(doctorDTO.getName());
        doctor.setSurname(doctorDTO.getSurname());
        doctor.setUcidn(doctorDTO.getUcidn());
        doctor.setAddress(doctorDTO.getAddress());
        doctor.setCity(doctorDTO.getCity());
        doctor.setCountry(doctorDTO.getCountry());
        doctor.setEmail(doctorDTO.getEmail());
        doctor.setPhone(doctorDTO.getPhone());
        doctor.setUsername(doctorDTO.getUsername());
        doctor.setPassword(passwordEncoder.encode(doctorDTO.getPassword()));
        doctor.setGrade((double) 0);
        doctor.setRole("DOCTOR");
        doctor.setActivated(true);
        Authority doctorAutority = authorityRepository.findByName(UserRoles.ROLE_DOCTOR);
        doctor.getUsersAuthorities().add(doctorAutority);
        doctor = doctorService.save(doctor);


        return new ResponseEntity<>(new DoctorDTO(doctor), HttpStatus.CREATED);
    }

    @DeleteMapping(value = "/del/{email}")
    public ResponseEntity<String> deletePost(@PathVariable String email) {

        doctorService.remove(email);
        return new ResponseEntity<>(email, HttpStatus.OK);
    }


}
