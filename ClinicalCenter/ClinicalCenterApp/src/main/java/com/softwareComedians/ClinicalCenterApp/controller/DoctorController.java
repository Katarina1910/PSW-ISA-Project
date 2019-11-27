package com.softwareComedians.ClinicalCenterApp.controller;

import com.softwareComedians.ClinicalCenterApp.dto.DoctorDTO;
import com.softwareComedians.ClinicalCenterApp.dto.UserDTO;
import com.softwareComedians.ClinicalCenterApp.model.Doctor;
import com.softwareComedians.ClinicalCenterApp.model.RequestForPatientRegistration;
import com.softwareComedians.ClinicalCenterApp.model.User;
import com.softwareComedians.ClinicalCenterApp.service.DoctorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "api/doctors")
@CrossOrigin
public class DoctorController {

    @Autowired
    DoctorService doctorService;

    @PostMapping()
    public ResponseEntity<DoctorDTO> addDoctor(@RequestBody DoctorDTO doctorDTO) {
        Doctor doctor = new Doctor();
        if(doctorService.findByEmail(doctorDTO.getEmail())!=null){
            return new ResponseEntity<>(new DoctorDTO(doctor), HttpStatus.BAD_REQUEST);
        }
        if(doctorService.findByUICDN(doctorDTO.getUcidn())!=null){
            return new ResponseEntity<>(new DoctorDTO(doctor), HttpStatus.BAD_REQUEST);
        }
        if(doctorService.findByUserName(doctorDTO.getUserName())!=null){
            return new ResponseEntity<>(new DoctorDTO(doctor), HttpStatus.BAD_REQUEST);
        }

        doctor.setId(doctorDTO.getId());
        doctor.setName(doctorDTO.getName());
        doctor.setSurname(doctorDTO.getSurname());
        doctor.setUcidn(doctorDTO.getUcidn());
        doctor.setAddress(doctorDTO.getAddress());
        doctor.setCity(doctorDTO.getCity());
        doctor.setCountry(doctorDTO.getCountry());
        doctor.setEmail(doctorDTO.getEmail());
        doctor.setPhone(doctorDTO.getPhone());
        doctor.setUserName(doctorDTO.getUserName());
        doctor.setPassword(doctorDTO.getPassword());
        doctor.setGrade(0);
        doctor.setRole("DOCTOR");

        doctor = doctorService.save(doctor);


        return new ResponseEntity<>(new DoctorDTO(doctor), HttpStatus.CREATED);
    }
}
