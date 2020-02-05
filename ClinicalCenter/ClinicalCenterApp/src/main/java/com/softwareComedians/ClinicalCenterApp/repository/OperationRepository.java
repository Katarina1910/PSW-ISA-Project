package com.softwareComedians.ClinicalCenterApp.repository;

import com.softwareComedians.ClinicalCenterApp.model.Operation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OperationRepository extends JpaRepository<Operation, Long> {
}
