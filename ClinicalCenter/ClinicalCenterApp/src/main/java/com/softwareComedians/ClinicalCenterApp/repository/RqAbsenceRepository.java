package com.softwareComedians.ClinicalCenterApp.repository;

import com.softwareComedians.ClinicalCenterApp.model.RequestForAbsence;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RqAbsenceRepository extends JpaRepository<RequestForAbsence, Long> {
}
