package com.softwareComedians.ClinicalCenterApp.repository;

import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User,Long> {
  //  User findOneByUCIDN(String ucidn);
   // Page<User> findAll(Pageable pageable);
   // User findOneById(Long id);

}
