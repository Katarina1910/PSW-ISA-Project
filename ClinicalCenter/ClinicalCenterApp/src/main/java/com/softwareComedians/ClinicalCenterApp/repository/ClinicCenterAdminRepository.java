package com.softwareComedians.ClinicalCenterApp.repository;

import com.softwareComedians.ClinicalCenterApp.model.ClinicCenterAdministrator;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClinicCenterAdminRepository extends JpaRepository<ClinicCenterAdministrator,Long> {

    ClinicCenterAdministrator findByName(String name);
    void deleteById(Long id);
}
