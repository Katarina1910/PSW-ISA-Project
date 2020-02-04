package com.softwareComedians.ClinicalCenterApp.repository;

import com.softwareComedians.ClinicalCenterApp.model.RoomTerms;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface RoomTermRepository extends JpaRepository<RoomTerms, Long> {
    List<RoomTerms> findByDate(String date);

}
