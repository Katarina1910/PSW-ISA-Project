package com.softwareComedians.ClinicalCenterApp.service;

import com.softwareComedians.ClinicalCenterApp.common.consts.UserRoles;
import com.softwareComedians.ClinicalCenterApp.dto.ClinicAdminDTO;
import com.softwareComedians.ClinicalCenterApp.model.Authority;
import com.softwareComedians.ClinicalCenterApp.model.Clinic;
import com.softwareComedians.ClinicalCenterApp.model.ClinicAdministrator;
import com.softwareComedians.ClinicalCenterApp.repository.AuthorityRepository;
import com.softwareComedians.ClinicalCenterApp.repository.ClinicAdminRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClinicAdminService {

    @Autowired
    private ClinicAdminRepository clinicAdminRepository;

    @Autowired
    private AuthorityRepository authorityRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    ClinicsService clinicsService;

    public ClinicAdministrator findOne(Long id){
        return clinicAdminRepository.findById(id).orElseGet(null);
    }

    public List<ClinicAdministrator> findAll(){return  clinicAdminRepository.findAll();}

    public ClinicAdministrator findById(Long id){
        ClinicAdministrator clinicAdministrator = clinicAdminRepository.findById(id).orElseGet(null);
        return clinicAdministrator;
    }

    public ClinicAdministrator findByName(String name){
        for(ClinicAdministrator ca:clinicAdminRepository.findAll()){
            if(ca.getName().equals(name)){
                return ca;
            }
        }
        return null;
    }

    public ClinicAdministrator save(ClinicAdministrator ca){ return clinicAdminRepository.save(ca);}

    public void remove(Long id){
        ClinicAdministrator ca = clinicAdminRepository.findById(id).orElseGet(null);
        if(ca!=null){
            clinicAdminRepository.delete(ca);
        }
    }

    public ClinicAdministrator addNew(ClinicAdminDTO clinicAdminDTO){
        ClinicAdministrator clinicAdministrator = new ClinicAdministrator();
        clinicAdministrator.setId(clinicAdminDTO.getId());
        clinicAdministrator.setName(clinicAdminDTO.getName());
        clinicAdministrator.setSurname(clinicAdminDTO.getSurname());
        clinicAdministrator.setUcidn(clinicAdminDTO.getUcidn());
        clinicAdministrator.setAddress(clinicAdminDTO.getAddress());
        clinicAdministrator.setCity(clinicAdminDTO.getCity());
        clinicAdministrator.setCountry(clinicAdminDTO.getCountry());
        clinicAdministrator.setEmail(clinicAdminDTO.getEmail());
        clinicAdministrator.setPassword(passwordEncoder.encode(clinicAdminDTO.getPassword()));

        clinicAdministrator.setRole(UserRoles.ROLE_CA);
        clinicAdministrator.setActivated(true);
        Authority caAutority = authorityRepository.findByName(UserRoles.ROLE_CA);
        clinicAdministrator.getUsersAuthorities().add(caAutority);

        Clinic c = clinicsService.findById(clinicAdminDTO.getClinic().getId());
        clinicAdministrator.setClinic(c);

        clinicAdministrator.setPasswordChanged(false);
        clinicAdministrator = this.save(clinicAdministrator);
        return  clinicAdministrator;
    }
}
