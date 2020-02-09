package com.softwareComedians.ClinicalCenterApp.service;

import com.softwareComedians.ClinicalCenterApp.dto.PatientDTO;
import com.softwareComedians.ClinicalCenterApp.model.Patient;
import com.softwareComedians.ClinicalCenterApp.model.User;
import com.softwareComedians.ClinicalCenterApp.repository.PatientRepository;
import com.softwareComedians.ClinicalCenterApp.service.impl.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class PatientService {

    private PatientRepository patientRepository;


    @Autowired
    private UserServiceImpl userService;


    @Autowired
    public PatientService(PatientRepository patientRepository) {
        this.patientRepository = patientRepository;
    }


    public Patient save(Patient patient) {
        return patientRepository.save(patient);
    }

    public Patient findById(Long id) {
        return patientRepository.findById(id).orElseGet(null);
    }

    public List<Patient> findAll() { return patientRepository.findAll(); }

    public List<PatientDTO> getAll() {

        List<Patient> patients = this.findAll();
        List<PatientDTO> patientsDTO = new ArrayList<>();
        for (Patient p : patients) {
            patientsDTO.add(new PatientDTO(p));
        }
        return patientsDTO;
    }


    public User editPatient( PatientDTO patientDTO) {

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

        return userInfo;
    }


}
