package com.softwareComedians.ClinicalCenterApp.model;

import com.softwareComedians.ClinicalCenterApp.dto.ConsultTypeDTO;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;
import java.util.Set;

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
    private String description;

    @OneToMany(mappedBy = "type", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    Set<RequestForConsult> requestForConsultSet;

    @Column
    @OneToMany(mappedBy = "type", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    List<ConsultTerm> consultTerms;

    public ConsultType() {
    }

    public ConsultType(Long id, String name, String description) {
        this.id = id;
        this.name = name;
        this.description = description;
    }

    public  ConsultType(ConsultTypeDTO c){
        this.name = c.getName();
        this.description = c.getDescription();
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<ConsultTerm> getConsultTerms() {
        return consultTerms;
    }

    public void setConsultTerms(List<ConsultTerm> consultTerms) {
        this.consultTerms = consultTerms;
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
