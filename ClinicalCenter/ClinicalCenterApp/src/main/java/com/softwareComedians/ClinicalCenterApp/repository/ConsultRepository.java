package com.softwareComedians.ClinicalCenterApp.repository;

import com.softwareComedians.ClinicalCenterApp.model.Consult;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ConsultRepository extends JpaRepository<Consult, Long> {

    @Query("select c from Consult c where c.consultTerm.patient.id =?1")
    List<Consult> findConsults(Long id);
}
