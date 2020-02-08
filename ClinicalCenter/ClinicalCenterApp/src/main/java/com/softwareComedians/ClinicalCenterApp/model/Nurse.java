package com.softwareComedians.ClinicalCenterApp.model;

import lombok.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;

import javax.persistence.*;
import java.util.Set;

@Entity
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Nurse extends Personnel {

    @Autowired
    @Transient
    private PasswordEncoder passwordEncoder;

    @OneToMany(mappedBy = "nurse")
    public Set<Consult> consults;

    @OneToMany(fetch = FetchType.LAZY,  mappedBy = "nurse")
    private Set<Recipe> recipes;

}
