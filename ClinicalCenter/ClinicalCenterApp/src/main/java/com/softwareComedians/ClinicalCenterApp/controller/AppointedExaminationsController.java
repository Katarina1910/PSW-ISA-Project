package com.softwareComedians.ClinicalCenterApp.controller;

import com.softwareComedians.ClinicalCenterApp.dto.AppointedExaminationsDTO;
import com.softwareComedians.ClinicalCenterApp.model.AppointedExaminations;
import com.softwareComedians.ClinicalCenterApp.model.Doctor;
import com.softwareComedians.ClinicalCenterApp.service.impl.AppointedExaminationsImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.Collection;

@RestController
@RequestMapping("/api/appointedExaminations")
public class AppointedExaminationsController {

    @Autowired
    private AppointedExaminationsImpl appointedExaminationsService;

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public Collection<AppointedExaminations> getExaminations() {
        return appointedExaminationsService.findAll();
    }

    @GetMapping(value = "/{idExamination}", produces = MediaType.APPLICATION_JSON_VALUE)
    public AppointedExaminations getExaminationByID(@PathVariable("idExamination") Long id) {
        return appointedExaminationsService.findById(id);
    }
/*
    @GetMapping(value = "/getAppointed/{DoctorID}", produces = MediaType.APPLICATION_JSON_VALUE)
    public Collection<AppointedExaminations> getExaminationByDoctorID(@PathVariable("DoctorID") Long id) {

        return appointedExaminationsService.findByIdDoctor(id);
    }

    @GetMapping(value = "/getAppointedPatients/{PatientID}", produces = MediaType.APPLICATION_JSON_VALUE)
    public Collection<AppointedExaminations> getExaminationByPatientID(@PathVariable("PatientID") Long id) {

        return appointedExaminationsService.findByIdPatient(id);
    }
*/
    @PostMapping( value = "/add")
    public ResponseEntity<?> addExamination(@RequestBody AppointedExaminationsDTO examinationDTO) throws Exception {

        AppointedExaminations appexm = new AppointedExaminations();

        appexm.setDateTime(examinationDTO.getDateAndTime());
        appexm.setDuration(examinationDTO.getDuration());
        appexm.setDoctor(examinationDTO.getDoctor());
        appexm.setType(examinationDTO.getType());
        appexm.setRoom(examinationDTO.getRoom());
        appexm.setPrice(examinationDTO.getPrice());
        appexm.setDiscount(examinationDTO.getDiscount());



        if (appexm.getDuration() < 1) {
            return new ResponseEntity<>("Error! Duration is smaller then 1!", HttpStatus.METHOD_NOT_ALLOWED);
        }

        if (appexm.getPrice() < 0) {
            return new ResponseEntity<>("Error! Price is smaller then 0!", HttpStatus.METHOD_NOT_ALLOWED);
        }
/*
        LocalDateTime dateTimeNow = LocalDateTime.now();

        int compareValue = appexm.getDateTime().compareTo(dateTimeNow);

        if (compareValue < 0) {
            return new ResponseEntity<>("Error! Date is in the past!", HttpStatus.METHOD_NOT_ALLOWED);
        }
*/
        appexm = appointedExaminationsService.save(appexm);

        return new ResponseEntity<>(new AppointedExaminationsDTO(appexm), HttpStatus.CREATED);
    }

    @DeleteMapping(value = "/delete/{id}")
    public ResponseEntity<?> deleteExaminationByID(@PathVariable("id") Long id) {
        appointedExaminationsService.delete(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @PutMapping(value = "editAppointedExamination/{id}", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<AppointedExaminations> editAppointedExamination(@RequestBody AppointedExaminations examination, @PathVariable Long id)
            throws Exception {
        AppointedExaminations p = appointedExaminationsService.update(examination);
        return new ResponseEntity<AppointedExaminations>(p, HttpStatus.CREATED);
    }
}
