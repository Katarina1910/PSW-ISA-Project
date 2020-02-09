package com.softwareComedians.ClinicalCenterApp.repository;

import com.softwareComedians.ClinicalCenterApp.model.RequestForAbsence;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RqAbsenceRepository extends JpaRepository<RequestForAbsence, Long> {

    @Query("select r from RequestForAbsence r where r.applicant.id =?1")
    List<RequestForAbsence> findAllByUserId(Long id);
}
