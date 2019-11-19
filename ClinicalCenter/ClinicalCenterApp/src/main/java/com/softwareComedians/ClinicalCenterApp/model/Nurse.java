package com.softwareComedians.ClinicalCenterApp.model;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import java.util.Set;

@Entity
public class Nurse extends Personnel {
    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL, mappedBy = "nurse")
    private Set<Recipe> recipes;

}
