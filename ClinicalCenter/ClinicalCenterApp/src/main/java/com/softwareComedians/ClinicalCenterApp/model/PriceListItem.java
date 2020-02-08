package com.softwareComedians.ClinicalCenterApp.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
public class PriceListItem {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String name;

    @Column
    private double price;

    @ManyToOne(fetch = FetchType.LAZY)
    private PriceList priceList;

    public PriceListItem(String name, double price) {
        this.name = name;
        this.price = price;
    }

    public PriceListItem() {
    }


}
