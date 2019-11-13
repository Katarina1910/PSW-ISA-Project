package com.softwareComedians.ClinicalCenterApp.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Set;

//@Entity
@Getter
@Setter
public class PriceList {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

  //  @OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL, mappedBy = "priceList")
 //   private Set<PriceListItem>  priceList;

    @Column
    private Clinic clinic;


    public PriceList() {

    }


}
