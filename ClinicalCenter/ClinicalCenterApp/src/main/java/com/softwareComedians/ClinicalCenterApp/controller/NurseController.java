package com.softwareComedians.ClinicalCenterApp.controller;

import com.softwareComedians.ClinicalCenterApp.common.consts.UserRoles;
import com.softwareComedians.ClinicalCenterApp.dto.NurseDTO;
import com.softwareComedians.ClinicalCenterApp.model.Authority;
import com.softwareComedians.ClinicalCenterApp.model.ClinicAdministrator;
import com.softwareComedians.ClinicalCenterApp.model.Nurse;
import com.softwareComedians.ClinicalCenterApp.model.Personnel;
import com.softwareComedians.ClinicalCenterApp.repository.AuthorityRepository;
import com.softwareComedians.ClinicalCenterApp.repository.UserRepository;
import com.softwareComedians.ClinicalCenterApp.service.NurseService;
import net.bytebuddy.asm.Advice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping(value = "api/nurses")
@CrossOrigin
public class NurseController {

    @Autowired
    UserRepository userRepository;

    @Autowired
    NurseService nurseService;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private AuthorityRepository authorityRepository;

    @Autowired
    public NurseController(NurseService nurseService){this.nurseService = nurseService;}

    @GetMapping(value="/getAll")
    public ResponseEntity<List<NurseDTO>> getAll() {

        List<Nurse> nurses = nurseService.findAll();
        List<NurseDTO> nursesDTO = new ArrayList<>();
        for (Nurse n : nurses) {
            nursesDTO.add(new NurseDTO(n));
        }

        return new ResponseEntity<>(nursesDTO, HttpStatus.OK);
    }

    @PostMapping()
    public ResponseEntity<NurseDTO> addNurse(@RequestBody NurseDTO nurseDTO) {
        Nurse nurse = new Nurse();
        nurse.setId(nurseDTO.getId());
        nurse.setName(nurseDTO.getName());
        nurse.setSurname((nurseDTO.getSurname()));
        nurse.setUcidn(nurseDTO.getUcidn());
        nurse.setEmail(nurseDTO.getEmail());
        nurse.setPassword(passwordEncoder.encode(nurseDTO.getPassword()));
        nurse.setUsername(nurseDTO.getUsername());
        nurse.setPhone(nurseDTO.getPhone());
        nurse.setAddress(nurseDTO.getAddress());
        nurse.setCity(nurseDTO.getCity());
        nurse.setCountry(nurseDTO.getCountry());
        nurse.setActivated(nurseDTO.isActivated());
        nurse.setRole("ROLE_NURSE");
        nurse.setActivated(true);
        Authority nurseAutority = authorityRepository.findByName(UserRoles.ROLE_NURSE);
        nurse.getUsersAuthorities().add(nurseAutority);
       /* Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String username = authentication.getName();
        ClinicAdministrator ca = (ClinicAdministrator) userRepository.findByEmail(username);
        nurse.setClinic(ca.getClinic());*/
        nurse = nurseService.save(nurse);




        return new ResponseEntity<>(new NurseDTO(nurse), HttpStatus.CREATED);
    }


    @DeleteMapping(value = "/del/{id}")
    public ResponseEntity<Long> deletePost(@PathVariable Long id) {

        nurseService.remove(id);
        return new ResponseEntity<>(id, HttpStatus.OK);
    }
}
