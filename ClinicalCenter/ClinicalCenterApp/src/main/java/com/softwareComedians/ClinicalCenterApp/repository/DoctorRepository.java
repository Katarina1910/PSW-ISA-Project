package com.softwareComedians.ClinicalCenterApp.repository;

import com.softwareComedians.ClinicalCenterApp.model.Doctor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DoctorRepository extends JpaRepository<Doctor,Long> {
    Doctor findByEmail(String email);
}
