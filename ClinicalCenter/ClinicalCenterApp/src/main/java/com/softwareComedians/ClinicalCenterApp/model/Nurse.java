package com.softwareComedians.ClinicalCenterApp.model;

import com.softwareComedians.ClinicalCenterApp.dto.NurseDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;

import javax.persistence.*;
import java.util.Set;

@Entity
public class Nurse extends Personnel {

    @Autowired
    @Transient
    private PasswordEncoder passwordEncoder;

    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL, mappedBy = "nurse")
    private Set<Recipe> recipes;

    public Nurse(NurseDTO n){
        this.setId(n.getId());
        this.setName(n.getName());
        this.setSurname((n.getSurname()));
        this.setUcidn(n.getUcidn());
        this.setEmail(n.getEmail());
        this.setPassword(passwordEncoder.encode(n.getPassword()));
        this.setUsername(n.getUsername());
        this.setPhone(n.getPhone());
        this.setAddress(n.getAddress());
        this.setCity(n.getCity());
        this.setCountry(n.getCountry());
        this.setActivated(n.isActivated());
        this.setRole("NURSE");
    }
}
