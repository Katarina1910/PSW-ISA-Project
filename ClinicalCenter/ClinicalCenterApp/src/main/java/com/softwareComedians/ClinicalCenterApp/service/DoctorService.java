package com.softwareComedians.ClinicalCenterApp.service;

import com.softwareComedians.ClinicalCenterApp.common.consts.UserRoles;
import com.softwareComedians.ClinicalCenterApp.dto.DoctorDTO;
import com.softwareComedians.ClinicalCenterApp.exception.ApiRequestException;
import com.softwareComedians.ClinicalCenterApp.model.Authority;
import com.softwareComedians.ClinicalCenterApp.model.ClinicAdministrator;
import com.softwareComedians.ClinicalCenterApp.model.Doctor;
import com.softwareComedians.ClinicalCenterApp.model.Operation;
import com.softwareComedians.ClinicalCenterApp.repository.AuthorityRepository;
import com.softwareComedians.ClinicalCenterApp.repository.DoctorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

@Service
public class DoctorService {

    @Autowired
    private DoctorRepository doctorRepository;


    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private ClinicAdminService clinicAdminService;

    @Autowired
    private AuthorityRepository authorityRepository;



    public Doctor findOne(Long id) {
        try {
            return doctorRepository.findById(id).get();
        } catch (NoSuchElementException e) {
            throw new ApiRequestException("Doctor with id '" + id + "' doesn't exist.");
        }
    }


    public Doctor findByName(String name){
        return doctorRepository.findByName(name);
    }

    public List<Doctor> findAll(){
        return doctorRepository .findAll();
    }

    public Doctor findByEmail(String email){

        Doctor user = doctorRepository.findByEmail(email);

        return user;

    }

    public Doctor findByUserName(String userName){
        for(Doctor u : doctorRepository.findAll()){
            if(u.getUsername().equals(userName)){
                return u;
            }
        }
        return null;
    }

    public Doctor findByUICDN(String uicdn){
        for(Doctor u : doctorRepository.findAll()){
            if(u.getUcidn().equals(uicdn)){
                return u;
            }
        }
        return null;
    }


    public Doctor save(Doctor u) {
        return doctorRepository.save(u);
    }

    public void remove(Long id){
        doctorRepository.deleteById(id);
    }

    public void remove(String email) {
      Doctor d =  doctorRepository.findByEmail(email);
      if(d!=null){
          doctorRepository.delete(d);
      }
    }

    public Doctor addDoctor(Long id, DoctorDTO doctorDTO) {
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
        doctor.setTypeId(null);
        doctor.setRole("DOCTOR");
        doctor.setActivated(true);
        ClinicAdministrator ca = clinicAdminService.findById(id);
        if (ca!=null){
            doctor.setClinic(ca.getClinic());
        }
        Authority doctorAutority = authorityRepository.findByName(UserRoles.ROLE_DOCTOR);
        doctor.getUsersAuthorities().add(doctorAutority);
        doctor = this.save(doctor);
        return doctor;
    }

    public Doctor rateDoctorGrade (DoctorDTO doctorDTO,Double rate) {
        Doctor doc = this.findOne(doctorDTO.getId());
        Double r = (doc.getGrade()+rate)/2;
        doc.setGrade(r);
        doc = this.save(doc);

        return doc;
    }

    public List<DoctorDTO> getAllDoctors() {

        List<Doctor> doctors = this.findAll();
        List<DoctorDTO> doctorsDTO = new ArrayList<>();
        for (Doctor d : doctors) {
            doctorsDTO.add(new DoctorDTO(d));
        }
        return doctorsDTO;
    }

}
