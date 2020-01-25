package com.softwareComedians.ClinicalCenterApp.repository;

import com.softwareComedians.ClinicalCenterApp.model.AppointedExaminations;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AppointedExaminationsRepository extends JpaRepository<AppointedExaminations, Long> {

    List<AppointedExaminations> findAll();
/*
    List<AppointedExaminations> findByIdDoctor(Long idDoctor);

    List<AppointedExaminations> findByIdPatient(Long idPatient);
*/
}
