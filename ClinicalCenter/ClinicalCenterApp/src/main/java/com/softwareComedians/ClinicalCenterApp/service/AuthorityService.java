package com.softwareComedians.ClinicalCenterApp.service;

import com.softwareComedians.ClinicalCenterApp.model.Authority;

import java.util.List;

public interface AuthorityService {
    List<Authority> findById(Long id);
    List<Authority> findByName(String name);
}
