package com.softwareComedians.ClinicalCenterApp.repository;

import com.softwareComedians.ClinicalCenterApp.model.ConsultTerm;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ConsultTermRepository extends JpaRepository<ConsultTerm,Long> {

    List<ConsultTerm> findByTypeName(String typeName);

    @Query("select c from ConsultTerm c where c.doctor.id=?1")
    List<ConsultTerm> getConsultsDoctor(Long id);

    //@Query("select c from ConsultTerm c where c.nurse.id=?1")
    //List<ConsultTerm> getConsultsNurse(Long id);
}
