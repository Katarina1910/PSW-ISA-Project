package com.softwareComedians.ClinicalCenterApp.repository;

import com.softwareComedians.ClinicalCenterApp.model.DoctorTerms;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DoctorTermsRepository extends JpaRepository<DoctorTerms, Long> {
        List<DoctorTerms> findByDate(String date);

        }
