package com.softwareComedians.ClinicalCenterApp.repository;

import com.softwareComedians.ClinicalCenterApp.model.Nurse;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface NurseRepository  extends JpaRepository<Nurse,Long> {

    //Nurse findById(Long id);
    Nurse findByEmail(String email);
    Nurse findByName(String name);

    void deleteByEmail(String email);
}

