package com.softwareComedians.ClinicalCenterApp.repository;

import com.softwareComedians.ClinicalCenterApp.model.ConsultTerm;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ConsultTermRepository extends JpaRepository<ConsultTerm,Long> {

}
