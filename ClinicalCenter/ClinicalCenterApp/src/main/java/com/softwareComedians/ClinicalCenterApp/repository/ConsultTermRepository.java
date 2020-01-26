package com.softwareComedians.ClinicalCenterApp.repository;

import com.softwareComedians.ClinicalCenterApp.model.ConsultTerm;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ConsultTermRepository extends JpaRepository<ConsultTerm,Long> {

    List<ConsultTerm> findByTypeName(String typeName);
}
