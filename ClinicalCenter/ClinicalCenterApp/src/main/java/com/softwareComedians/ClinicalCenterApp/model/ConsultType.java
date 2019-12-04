package com.softwareComedians.ClinicalCenterApp.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Entity
@Getter
@Setter
public class ConsultType {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String name;

    @Column
    @OneToMany(mappedBy = "type", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    List<ConsultTerm> consultTerms;

    public ConsultType() {
    }

    public ConsultType(Long id, String name) {
        this.id = id;
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
