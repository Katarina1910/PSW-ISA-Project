package com.softwareComedians.ClinicalCenterApp.repository;

import com.softwareComedians.ClinicalCenterApp.model.Clinic;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClinicsRepository extends JpaRepository<Clinic,Long> {

        Clinic findByName(String name);
        void deleteById(Long id);
}
